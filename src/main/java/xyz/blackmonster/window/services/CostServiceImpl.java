package xyz.blackmonster.window.services;

import java.io.File;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import xyz.blackmonster.window.models.Cost;
import xyz.blackmonster.window.models.ServicePrice;
import xyz.blackmonster.window.models.TaxPrice;
import xyz.blackmonster.window.models.WindowPrice;
import xyz.blackmonster.window.models.WindowService;
import xyz.blackmonster.window.models.Window;
import xyz.blackmonster.window.models.WindowOrder;
import xyz.blackmonster.window.repositories.OrderRepository;
import xyz.blackmonster.window.repositories.ServicePriceRepository;
import xyz.blackmonster.window.repositories.TaxPriceRepository;
import xyz.blackmonster.window.repositories.WindowPriceRepository;
import xyz.blackmonster.window.types.TaxType;

@Service
public class CostServiceImpl implements CostService {

	private final OrderRepository orderRepository;

	private final ServicePriceRepository servicePriceRepository;

	private final TaxPriceRepository taxPriceRepository;

	private final WindowPriceRepository windowPriceRepository;

	@Autowired
	public CostServiceImpl(OrderRepository orderRepository, ServicePriceRepository servicePriceRepository, TaxPriceRepository taxPriceRepository, WindowPriceRepository windowPriceRepository) {
		this.orderRepository = orderRepository;
		this.servicePriceRepository = servicePriceRepository;
		this.taxPriceRepository = taxPriceRepository;
		this.windowPriceRepository = windowPriceRepository;
	}

	@Override
	public double calcWindowPrice(Window window) {
		WindowPrice price = windowPriceRepository.findByType(window.getType());
		if (price != null) {
			return window.getQuantity() * price.getPriceInfo().getValue();
		}
		return 0;
	}

	@Override
	public double calcServicePrice(WindowService windowService, double baseCost) {
		ServicePrice price = servicePriceRepository.findByType(windowService.getType());
		if (price != null) {
			return baseCost * (price.getPriceInfo().getValue() / 100.0);
		}
		return 0;
	}

	@Override
	public double calcTax(double baseCost) {
		TaxPrice price = taxPriceRepository.findByType(TaxType.VALUE_ADDED_TAX);
		if (price != null) {
			return baseCost * (1 + (price.getPriceInfo().getValue() / 100.0));
		}
		return 0;
	}

	@Override
	public Cost calcAll(WindowOrder windowOrder, boolean saveOrder) {
		Cost cost = new Cost();
		windowOrder.getWindows().forEach(window -> {
			window.setCost(calcWindowPrice(window));
			window.setWindowOrder(windowOrder);
		});
		final double windowCost = windowOrder.getWindows().stream().mapToDouble(Window::getCost).sum();
		cost.setWindowCost(windowCost);
		windowOrder.getServices().forEach(service -> {
			service.setCost(calcServicePrice(service, windowCost));
			service.setWindowOrder(windowOrder);
		});
		final double serviceCost = windowOrder.getServices().stream().mapToDouble(WindowService::getCost).sum();
		cost.setServiceCost(serviceCost);
		TaxPrice price = taxPriceRepository.findByType(TaxType.VALUE_ADDED_TAX);
		windowOrder.setValueAddedTaxPercentage(price.getPriceInfo().getValue());
		cost.setValueAddedTaxPercentage(price.getPriceInfo().getValue());
		cost.setTotalCost(calcTax(windowCost + serviceCost));

		if (saveOrder) {
			saveOrder(windowOrder);
		}

		return cost;
	}

	private void saveOrder(WindowOrder windowOrder) {
		LocalDate now = LocalDate.now();
		StringBuilder builder = new StringBuilder();
		builder.append(now.getYear());
		builder.append("-");
		builder.append(now.getMonthValue());
		builder.append(now.getDayOfMonth());
		long count = orderRepository.countTodaysOrders(builder.toString());
		builder.append("-");
		builder.append(count);
		windowOrder.setOrderNumber(builder.toString());

		orderRepository.save(windowOrder);
	}
}

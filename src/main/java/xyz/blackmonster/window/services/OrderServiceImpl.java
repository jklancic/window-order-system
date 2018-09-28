package xyz.blackmonster.window.services;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import xyz.blackmonster.window.converters.CostConverter;
import xyz.blackmonster.window.converters.OrderConverter;
import xyz.blackmonster.window.models.Cost;
import xyz.blackmonster.window.models.WindowOrder;
import xyz.blackmonster.window.repositories.OrderRepository;
import xyz.blackmonster.window.responses.CostWS;
import xyz.blackmonster.window.responses.OrderWS;

/**
 * WindowOrder service
 */
@Service
public class OrderServiceImpl implements OrderService {

	private final OrderRepository orderRepository;

	private final EmailService emailService;

	private final PDFService pdfService;

	@Autowired
	public OrderServiceImpl(OrderRepository orderRepository, EmailService emailService, PDFService pdfService) {
		this.orderRepository = orderRepository;
		this.emailService = emailService;
		this.pdfService = pdfService;
	}

	@Override
	public CostWS calculate(OrderWS orderWS) {
		Cost cost = calculate(new WindowOrder());

		return CostConverter.toWS(cost);
	}

	private Cost calculate(WindowOrder windowOrder) {
		Cost cost = new Cost();
		cost.setWindowCost(12000);
		cost.setServiceCost(2000);
		cost.setValueAddedTaxPercentage(20);
		int totalChargeWithoutTax = cost.getWindowCost() + cost.getServiceCost();
		cost.setTotalCost(totalChargeWithoutTax + (totalChargeWithoutTax * cost.getValueAddedTaxPercentage() / 100));

		return cost;
	}

	@Async
	@Override
	public void saveAndSentOrder(OrderWS orderWS) {
		WindowOrder windowOrder = OrderConverter.toModel(orderWS);
		Cost cost = calculate(windowOrder);
		windowOrder.setCost(cost);
		windowOrder.getCost().setWindowOrder(windowOrder);
		windowOrder.getService().setWindowOrder(windowOrder);
		windowOrder.getWindows().stream().forEach(window -> window.setWindowOrder(windowOrder));

		orderRepository.save(windowOrder);
		File createdPdf = pdfService.createPDF(windowOrder);
		emailService.sendEmail(createdPdf, windowOrder.getEmail());
	}
}

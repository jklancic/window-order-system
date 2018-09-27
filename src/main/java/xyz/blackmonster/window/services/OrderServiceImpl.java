package xyz.blackmonster.window.services;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import xyz.blackmonster.window.converters.CostConverter;
import xyz.blackmonster.window.converters.OrderConverter;
import xyz.blackmonster.window.models.Cost;
import xyz.blackmonster.window.models.Order;
import xyz.blackmonster.window.repositories.OrderRepository;
import xyz.blackmonster.window.responses.CostWS;
import xyz.blackmonster.window.responses.OrderWS;

/**
 * Order service
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
		Cost cost = calculate(new Order());

		return CostConverter.toWS(cost);
	}

	private Cost calculate(Order order) {
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
		Order order = OrderConverter.toModel(orderWS);
		Cost cost = calculate(order);
		order.setCost(cost);

		orderRepository.save(order);
		File createdPdf = pdfService.createPDF(order);
		emailService.sendEmail(createdPdf, order.getEmail());
	}
}

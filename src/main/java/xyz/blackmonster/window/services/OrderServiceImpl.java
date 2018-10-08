package xyz.blackmonster.window.services;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import xyz.blackmonster.window.models.Cost;
import xyz.blackmonster.window.models.WindowOrder;
import xyz.blackmonster.window.repositories.OrderRepository;

/**
 * WindowOrder service
 */
@Service
public class OrderServiceImpl implements OrderService {

	private final CostService costService;

	private final EmailService emailService;

	private final PDFService pdfService;

	private final OrderRepository orderRepository;

	@Autowired
	public OrderServiceImpl(CostService costService, EmailService emailService, PDFService pdfService, OrderRepository orderRepository) {
		this.costService = costService;
		this.emailService = emailService;
		this.pdfService = pdfService;
		this.orderRepository = orderRepository;
	}

	@Async
	@Override
	public void saveAndSentOrder(WindowOrder windowOrder) {
		Cost cost = costService.calcAll(windowOrder, true);
		File createdPdf = pdfService.createPDF(windowOrder, cost);
		emailService.sendEmail(createdPdf, windowOrder.getEmail());
	}

	@Override
	public List<WindowOrder> listLastOrders() {
		return orderRepository.findAll();
	}

	@Override
	public Optional<WindowOrder> retrieveOrder(String uuid) {
		return orderRepository.findById(uuid);
	}
}

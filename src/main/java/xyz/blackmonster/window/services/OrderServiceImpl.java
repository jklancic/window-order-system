package xyz.blackmonster.window.services;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import xyz.blackmonster.window.models.Cost;
import xyz.blackmonster.window.models.WindowOrder;

/**
 * WindowOrder service
 */
@Service
public class OrderServiceImpl implements OrderService {

	private final CostService costService;

	private final EmailService emailService;

	private final PDFService pdfService;

	@Autowired
	public OrderServiceImpl(CostService costService, EmailService emailService, PDFService pdfService) {
		this.costService = costService;
		this.emailService = emailService;
		this.pdfService = pdfService;
	}

	@Async
	@Override
	public void saveAndSentOrder(WindowOrder windowOrder) {
		Cost cost = costService.calcAll(windowOrder, true);
		File createdPdf = pdfService.createPDF(windowOrder, cost);
		emailService.sendEmail(createdPdf, windowOrder.getEmail());
	}
}

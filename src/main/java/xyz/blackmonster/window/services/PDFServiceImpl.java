package xyz.blackmonster.window.services;

import java.io.File;

import org.springframework.stereotype.Service;

import xyz.blackmonster.window.models.Order;

/**
 * Email service
 */
@Service
public class PDFServiceImpl implements PDFService {

	@Override
	public File createPDF(Order order) {
		return null;
	}
}

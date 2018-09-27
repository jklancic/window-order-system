package xyz.blackmonster.window.services;

import java.io.File;

import xyz.blackmonster.window.models.Order;

public interface PDFService {

	File createPDF(Order order);
}

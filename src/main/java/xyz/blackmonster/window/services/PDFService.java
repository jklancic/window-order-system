package xyz.blackmonster.window.services;

import java.io.File;

import xyz.blackmonster.window.models.Cost;
import xyz.blackmonster.window.models.WindowOrder;

public interface PDFService {

	File createPDF(WindowOrder windowOrder, Cost cost);
}

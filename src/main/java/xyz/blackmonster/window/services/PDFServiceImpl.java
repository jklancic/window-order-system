package xyz.blackmonster.window.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Clock;
import java.time.LocalDate;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.itextpdf.html2pdf.HtmlConverter;
import xyz.blackmonster.window.models.Cost;
import xyz.blackmonster.window.models.WindowOrder;

/**
 * Email service
 */
@Service
public class PDFServiceImpl implements PDFService {

	private static final Logger LOGGER = LoggerFactory.getLogger(PDFServiceImpl.class);

	private static String TEMP_FILE_PATH = "temp_%s";

	private final TranslationService translationService;

	@Autowired
	public PDFServiceImpl(TranslationService translationService) {
		this.translationService = translationService;
	}

	@Override
	public File createPDF(WindowOrder windowOrder, Cost cost) {

		String tempFilePath = String.format(TEMP_FILE_PATH, Clock.systemUTC().instant());
		try {
			Document invoiceContent = createInvoiceContent(windowOrder, cost);
			HtmlConverter.convertToPdf(invoiceContent.html(), new FileOutputStream(tempFilePath));
			return new File(tempFilePath);
		} catch (FileNotFoundException e) {
			LOGGER.error("File not found exception: " + e.getMessage(), e);
		} catch (IOException e) {
			LOGGER.error("IO exception: " + e.getMessage(), e);
		}

		return null;
	}

	private Document createInvoiceContent(WindowOrder windowOrder, Cost cost) throws IOException {
		File file = new ClassPathResource("templates/invoice.html").getFile();
		Document document = Jsoup.parse(file, "UTF-8");

		Elements invoiceInfo = document.select("#invoice-info");
		LocalDate now = LocalDate.now();
		invoiceInfo.append("<b>Ra\u010Dun \u0161t:</b> " + windowOrder.getOrderNumber() + "</br>");
		invoiceInfo.append("<b>Datum:</b> " + now + "</br>");
		invoiceInfo.append("<b>Veljaven do:</b> " + now.plusDays(90) + "</br>");

		Elements receiver = document.select("#invoice-receiver");
		receiver.append(windowOrder.getEmail());

		return document;
	}
}

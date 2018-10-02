package xyz.blackmonster.window.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.Clock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
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
//			File file = new ClassPathResource("countries.xml").getFile();
			PdfWriter writer = new PdfWriter(tempFilePath);
			//Initialize PDF document
			PdfDocument pdf = new PdfDocument(writer);
			// Initialize document
			Document document = new Document(pdf);
			//Add paragraph to the document
			document.add(new Paragraph("Hello World!"));
			//Close document
			document.close();
			return new File(tempFilePath);
		} catch (FileNotFoundException e) {
			LOGGER.error("File not found exception: " + e.getMessage(), e);
			return null;
		}
	}
}

package xyz.blackmonster.window.services;

import java.io.File;
import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

/**
 * Email service
 */
@Service
public class EmailServiceImpl implements EmailService {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmailServiceImpl.class);

	private final JavaMailSender javaMailSender;

	@Autowired
	public EmailServiceImpl(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	@Override
	public void sendEmail(File createdPdf, String receiver) {
		if (createdPdf == null) {
			LOGGER.error("PDF was not generated for " + receiver);
			return;
		}

		MimeMessage message = javaMailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message,true);
			helper.setTo(receiver);
			helper.setText(loadEmailContent(), true);
			helper.setSubject("Informativni izra\u010Dun za okna");
			helper.addAttachment("izra\u010Dun.pdf", createdPdf);
			javaMailSender.send(message);
		} catch (MessagingException e) {
			LOGGER.error("Email was not sent: " + e.getMessage(), e);
		} finally {
			boolean success = createdPdf.delete();
			if (!success) {
				LOGGER.error("Not able to delete file " + createdPdf.getAbsoluteFile());
			}
		}
	}

	private String loadEmailContent() {
		try {
			File file = new ClassPathResource("templates/email.html").getFile();
			Document document = Jsoup.parse(file, "UTF-8");
			// we need to remove the HTML tag
			return document.select("html").html();
		} catch (IOException e) {
			LOGGER.error("Email was not sent: " + e.getMessage(), e);
			return "Pozdravljeni, \n V prilogi boste nasli informativni izracun nabave oken.";
		}
	}
}

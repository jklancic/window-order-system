package xyz.blackmonster.window.services;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

/**
 * Email service
 */
@Service
public class EmailServiceImpl implements EmailService {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrderServiceImpl.class);

	private final JavaMailSender javaMailSender;

	@Autowired
	public EmailServiceImpl(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	@Override
	public void sendEmail(File createdPdf, String receiver) {
		MimeMessage message = javaMailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message,true);
			helper.setTo(receiver);
			helper.setText("Pozdravljeni, \n V prilogi boste nasli informativni izracun nabave oken.");
			helper.setSubject("Informativni izracun za okna");
			helper.addAttachment("izracun.pdf", createdPdf);
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
}

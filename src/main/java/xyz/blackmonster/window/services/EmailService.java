package xyz.blackmonster.window.services;

import java.io.File;

public interface EmailService {

	void sendEmail(File createdPdf, String receiver);
}

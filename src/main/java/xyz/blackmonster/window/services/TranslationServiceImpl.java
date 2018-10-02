package xyz.blackmonster.window.services;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

@Service
public class TranslationServiceImpl implements TranslationService {

	private final MessageSource messageSource;

	@Autowired
	public TranslationServiceImpl(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	@Override
	public String translate(String key) {
		return messageSource.getMessage(key, null, Locale.getDefault());
	}
}

package xyz.blackmonster.window.bootstrap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import xyz.blackmonster.window.models.PriceInfo;
import xyz.blackmonster.window.models.ServicePrice;
import xyz.blackmonster.window.models.TaxPrice;
import xyz.blackmonster.window.models.WindowPrice;
import xyz.blackmonster.window.repositories.ServicePriceRepository;
import xyz.blackmonster.window.repositories.TaxPriceRepository;
import xyz.blackmonster.window.repositories.WindowPriceRepository;
import xyz.blackmonster.window.types.ServiceType;
import xyz.blackmonster.window.types.TaxType;
import xyz.blackmonster.window.types.WindowType;

@Component
public class PriceBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	private static final Logger LOGGER = LoggerFactory.getLogger(PriceBootstrap.class);

	private final ServicePriceRepository servicePriceRepository;

	private final TaxPriceRepository taxPriceRepository;

	private final WindowPriceRepository windowPriceRepository;

	@Autowired
	public PriceBootstrap(ServicePriceRepository servicePriceRepository, TaxPriceRepository taxPriceRepository, WindowPriceRepository windowPriceRepository) {
		this.servicePriceRepository = servicePriceRepository;
		this.taxPriceRepository = taxPriceRepository;
		this.windowPriceRepository = windowPriceRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		LOGGER.debug("Loading mocked prices.");
		loadServicePrice();
		loadTaxPrices();
		loadWindowPrice();
	}

	private void loadServicePrice() {
		// DEINSTALLATION, DISPOSAL, SHIPPING, INSTALLATION, FINALIZATION

		ServicePrice deinstallPrice = new ServicePrice();
		PriceInfo priceInfo = createDummyPriceInfo(false);
		priceInfo.setServicePrice(deinstallPrice);
		deinstallPrice.setPriceInfo(priceInfo);
		deinstallPrice.setType(ServiceType.DEINSTALLATION);
		servicePriceRepository.save(deinstallPrice);

		ServicePrice disposalPrice = new ServicePrice();
		priceInfo = createDummyPriceInfo(false);
		priceInfo.setServicePrice(disposalPrice);
		disposalPrice.setPriceInfo(priceInfo);
		disposalPrice.setType(ServiceType.DISPOSAL);
		servicePriceRepository.save(disposalPrice);

		ServicePrice shippingPrice = new ServicePrice();
		priceInfo = createDummyPriceInfo(false);
		priceInfo.setServicePrice(shippingPrice);
		shippingPrice.setPriceInfo(priceInfo);
		shippingPrice.setType(ServiceType.SHIPPING);
		servicePriceRepository.save(shippingPrice);

		ServicePrice installPrice = new ServicePrice();
		priceInfo = createDummyPriceInfo(false);
		priceInfo.setServicePrice(installPrice);
		installPrice.setPriceInfo(priceInfo);
		installPrice.setType(ServiceType.INSTALLATION);
		servicePriceRepository.save(installPrice);

		ServicePrice finalWorkPrice = new ServicePrice();
		priceInfo = createDummyPriceInfo(false);
		priceInfo.setServicePrice(finalWorkPrice);
		finalWorkPrice.setPriceInfo(priceInfo);
		finalWorkPrice.setType(ServiceType.FINALIZATION);
		servicePriceRepository.save(finalWorkPrice);
	}

	private void loadTaxPrices() {
		TaxPrice additionalValuePrice = new TaxPrice();
		PriceInfo priceInfo = new PriceInfo();
		priceInfo.setFix(false);
		priceInfo.setValue(20.0);
		priceInfo.setTaxPrice(additionalValuePrice);
		additionalValuePrice.setPriceInfo(priceInfo);
		additionalValuePrice.setType(TaxType.VALUE_ADDED_TAX);
		taxPriceRepository.save(additionalValuePrice);
	}

	private void loadWindowPrice() {
		WindowPrice onePiecePrice = new WindowPrice();
		PriceInfo priceInfo = createDummyPriceInfo(true);
		priceInfo.setWindowPrice(onePiecePrice);
		onePiecePrice.setPriceInfo(priceInfo);
		onePiecePrice.setType(WindowType.ONE_PIECE);
		windowPriceRepository.save(onePiecePrice);

		WindowPrice twoPiecePrice = new WindowPrice();
		priceInfo = createDummyPriceInfo(true);
		priceInfo.setWindowPrice(twoPiecePrice);
		twoPiecePrice.setPriceInfo(priceInfo);
		twoPiecePrice.setType(WindowType.TWO_PIECE);
		windowPriceRepository.save(twoPiecePrice);

		WindowPrice fixPrice = new WindowPrice();
		priceInfo = createDummyPriceInfo(true);
		priceInfo.setWindowPrice(fixPrice);
		fixPrice.setPriceInfo(priceInfo);
		fixPrice.setType(WindowType.FIX);
		windowPriceRepository.save(fixPrice);

		WindowPrice slidePrice = new WindowPrice();
		priceInfo = createDummyPriceInfo(true);
		priceInfo.setWindowPrice(slidePrice);
		slidePrice.setPriceInfo(priceInfo);
		slidePrice.setType(WindowType.SLIDE);
		windowPriceRepository.save(slidePrice);
	}

	private PriceInfo createDummyPriceInfo(boolean fix) {
		PriceInfo priceInfo = new PriceInfo();
		priceInfo.setFix(fix);
		priceInfo.setValue(fix ? 100.0 : 10.0);

		return priceInfo;
	}
}

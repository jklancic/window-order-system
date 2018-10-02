package xyz.blackmonster.window.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class PriceInfo {

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid2")
	private String uuid;
	@Column(name = "fix")
	private boolean fix;
	@Column(name = "value")
	private double value;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "service_price_uuid")
	private ServicePrice servicePrice;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "window_price_uuid")
	private WindowPrice windowPrice;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tax_price_uuid")
	private TaxPrice taxPrice;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public boolean isFix() {
		return fix;
	}

	public void setFix(boolean fix) {
		this.fix = fix;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public ServicePrice getServicePrice() {
		return servicePrice;
	}

	public void setServicePrice(ServicePrice servicePrice) {
		this.servicePrice = servicePrice;
	}

	public WindowPrice getWindowPrice() {
		return windowPrice;
	}

	public void setWindowPrice(WindowPrice windowPrice) {
		this.windowPrice = windowPrice;
	}

	public TaxPrice getTaxPrice() {
		return taxPrice;
	}

	public void setTaxPrice(TaxPrice taxPrice) {
		this.taxPrice = taxPrice;
	}
}

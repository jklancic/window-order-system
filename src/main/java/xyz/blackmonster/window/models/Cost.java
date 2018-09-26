package xyz.blackmonster.window.models;

/**
 * Total costs
 */
public class Cost {

	private String uuid;
	private int windowCharge;
	private int serviceCharge;
	private int valueAddedTaxPercentage;
	private int totalCharge;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public int getWindowCharge() {
		return windowCharge;
	}

	public void setWindowCharge(int windowCharge) {
		this.windowCharge = windowCharge;
	}

	public int getServiceCharge() {
		return serviceCharge;
	}

	public void setServiceCharge(int serviceCharge) {
		this.serviceCharge = serviceCharge;
	}

	public int getValueAddedTaxPercentage() {
		return valueAddedTaxPercentage;
	}

	public void setValueAddedTaxPercentage(int valueAddedTaxPercentage) {
		this.valueAddedTaxPercentage = valueAddedTaxPercentage;
	}

	public int getTotalCharge() {
		return totalCharge;
	}

	public void setTotalCharge(int totalCharge) {
		this.totalCharge = totalCharge;
	}
}

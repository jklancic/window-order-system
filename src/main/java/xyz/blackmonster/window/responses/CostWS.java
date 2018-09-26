package xyz.blackmonster.window.responses;

/**
 * Rest response body for total costs
 */
public class CostWS {

	private int windowCharge;
	private int serviceCharge;
	private int valueAddedTaxPercentage;
	private int totalCharge;

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

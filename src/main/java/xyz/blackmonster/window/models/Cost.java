package xyz.blackmonster.window.models;

/**
 * Total costs
 */
public class Cost {

	private String uuid;
	private int windowCost;
	private int serviceCost;
	private int valueAddedTaxPercentage;
	private int totalCost;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public int getWindowCost() {
		return windowCost;
	}

	public void setWindowCost(int windowCost) {
		this.windowCost = windowCost;
	}

	public int getServiceCost() {
		return serviceCost;
	}

	public void setServiceCost(int serviceCost) {
		this.serviceCost = serviceCost;
	}

	public int getValueAddedTaxPercentage() {
		return valueAddedTaxPercentage;
	}

	public void setValueAddedTaxPercentage(int valueAddedTaxPercentage) {
		this.valueAddedTaxPercentage = valueAddedTaxPercentage;
	}

	public int getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}
}

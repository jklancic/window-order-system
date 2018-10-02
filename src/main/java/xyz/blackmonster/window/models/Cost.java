package xyz.blackmonster.window.models;

/**
 * Total costs
 */
public class Cost {

	private double windowCost;
	private double serviceCost;
	private double valueAddedTaxPercentage;
	private double totalCost;

	public double getWindowCost() {
		return windowCost;
	}

	public void setWindowCost(double windowCost) {
		this.windowCost = windowCost;
	}

	public double getServiceCost() {
		return serviceCost;
	}

	public void setServiceCost(double serviceCost) {
		this.serviceCost = serviceCost;
	}

	public double getValueAddedTaxPercentage() {
		return valueAddedTaxPercentage;
	}

	public void setValueAddedTaxPercentage(double valueAddedTaxPercentage) {
		this.valueAddedTaxPercentage = valueAddedTaxPercentage;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
}

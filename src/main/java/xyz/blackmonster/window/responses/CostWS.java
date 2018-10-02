package xyz.blackmonster.window.responses;

import javax.validation.constraints.Positive;

/**
 * Rest response body for total costs
 */
public class CostWS {

	@Positive
	private double windowCost;
	@Positive
	private double serviceCost;
	@Positive
	private double valueAddedTaxPercentage;
	@Positive
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

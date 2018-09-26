package xyz.blackmonster.window.responses;

import javax.validation.constraints.Positive;

/**
 * Rest response body for total costs
 */
public class CostWS {

	@Positive
	private int windowCost;
	@Positive
	private int serviceCost;
	@Positive
	private int valueAddedTaxPercentage;
	@Positive
	private int totalCost;

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

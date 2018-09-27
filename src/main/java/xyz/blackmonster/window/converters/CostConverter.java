package xyz.blackmonster.window.converters;

import xyz.blackmonster.window.models.Cost;
import xyz.blackmonster.window.responses.CostWS;

/**
 * Converts WS cost objects from and to cost models
 */
public class CostConverter {

	/**
	 * Converts Cost instance to CostWS instance
	 * @param cost
	 * @return
	 */
	public static CostWS toWS(Cost cost) {
		CostWS costWS = new CostWS();
		costWS.setWindowCost(cost.getWindowCost());
		costWS.setServiceCost(cost.getServiceCost());
		costWS.setValueAddedTaxPercentage(cost.getValueAddedTaxPercentage());
		costWS.setTotalCost(cost.getTotalCost());

		return costWS;
	}

	/**
	 * Converts CostWS instance to Cost instance
	 * @param costWS
	 * @return
	 */
	public static Cost toModel(CostWS costWS) {
		Cost cost = new Cost();
		cost.setWindowCost(costWS.getWindowCost());
		cost.setServiceCost(costWS.getServiceCost());
		cost.setValueAddedTaxPercentage(costWS.getValueAddedTaxPercentage());
		cost.setTotalCost(costWS.getTotalCost());

		return cost;
	}
}

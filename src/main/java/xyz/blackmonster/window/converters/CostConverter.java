package xyz.blackmonster.window.converters;

import xyz.blackmonster.window.models.Cost;
import xyz.blackmonster.window.responses.rest.CostWS;

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
}

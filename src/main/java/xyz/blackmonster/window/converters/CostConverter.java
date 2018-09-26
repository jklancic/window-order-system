package xyz.blackmonster.window.converters;

import xyz.blackmonster.window.models.Cost;
import xyz.blackmonster.window.responses.CostWS;

/**
 * Converts WS objects from and to base models
 */
public class CostConverter {

	/**
	 * Converts Cost instance to CostWS instance
	 * @param cost
	 * @return
	 */
	public static CostWS toWS(Cost cost) {
		CostWS costWS = new CostWS();
		costWS.setWindowCharge(cost.getWindowCharge());
		costWS.setServiceCharge(cost.getServiceCharge());
		costWS.setValueAddedTaxPercentage(cost.getValueAddedTaxPercentage());
		costWS.setTotalCharge(cost.getTotalCharge());

		return costWS;
	}
}

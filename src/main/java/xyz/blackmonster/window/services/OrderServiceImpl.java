package xyz.blackmonster.window.services;

import org.springframework.stereotype.Component;

import xyz.blackmonster.window.converters.CostConverter;
import xyz.blackmonster.window.models.Cost;
import xyz.blackmonster.window.responses.CostWS;
import xyz.blackmonster.window.responses.OrderWS;

@Component
public class OrderServiceImpl implements OrderService {


	@Override
	public CostWS calculate(OrderWS orderWS) {

		Cost cost = new Cost();
		cost.setWindowCharge(12000);
		cost.setServiceCharge(2000);
		cost.setValueAddedTaxPercentage(20);
		int totalChargeWithoutTax = cost.getWindowCharge() + cost.getServiceCharge();
		cost.setTotalCharge(totalChargeWithoutTax + (totalChargeWithoutTax * cost.getValueAddedTaxPercentage() / 100));

		return CostConverter.toWS(cost);
	}
}

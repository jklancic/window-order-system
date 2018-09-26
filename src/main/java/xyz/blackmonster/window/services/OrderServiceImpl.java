package xyz.blackmonster.window.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import xyz.blackmonster.window.converters.CostConverter;
import xyz.blackmonster.window.models.Cost;
import xyz.blackmonster.window.repositories.OrderRepositoriy;
import xyz.blackmonster.window.responses.CostWS;
import xyz.blackmonster.window.responses.OrderWS;

@Component
public class OrderServiceImpl implements OrderService {

	private OrderRepositoriy orderRepositoriy;

	@Autowired
	public OrderServiceImpl(OrderRepositoriy orderRepositoriy) {
		this.orderRepositoriy = orderRepositoriy;
	}

	@Override
	public CostWS calculate(OrderWS orderWS) {

		Cost cost = new Cost();
		cost.setWindowCost(12000);
		cost.setServiceCost(2000);
		cost.setValueAddedTaxPercentage(20);
		int totalChargeWithoutTax = cost.getWindowCost() + cost.getServiceCost();
		cost.setTotalCost(totalChargeWithoutTax + (totalChargeWithoutTax * cost.getValueAddedTaxPercentage() / 100));

		return CostConverter.toWS(cost);
	}
}

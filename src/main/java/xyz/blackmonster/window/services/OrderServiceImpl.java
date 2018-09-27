package xyz.blackmonster.window.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.blackmonster.window.converters.CostConverter;
import xyz.blackmonster.window.models.Cost;
import xyz.blackmonster.window.repositories.OrderRepository;
import xyz.blackmonster.window.responses.CostWS;
import xyz.blackmonster.window.responses.OrderWS;

@Service
public class OrderServiceImpl implements OrderService {

	private OrderRepository orderRepository;

	@Autowired
	public OrderServiceImpl(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
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

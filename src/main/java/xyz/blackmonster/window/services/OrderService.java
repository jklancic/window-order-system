package xyz.blackmonster.window.services;

import xyz.blackmonster.window.responses.CostWS;
import xyz.blackmonster.window.responses.OrderWS;

public interface OrderService {

	CostWS calculate(OrderWS orderWS);

	void saveAndSentOrder(OrderWS orderWS);
}

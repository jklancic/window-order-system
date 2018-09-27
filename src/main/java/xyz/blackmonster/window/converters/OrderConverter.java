package xyz.blackmonster.window.converters;

import xyz.blackmonster.window.models.Order;
import xyz.blackmonster.window.responses.OrderWS;

/**
 * Converts WS order objects from and to order models
 */
public class OrderConverter {

	/**
	 * Converts Order instance to OrderWS instance
	 * @param order
	 * @return
	 */
	public static OrderWS toWS(Order order) {
		OrderWS orderWS = new OrderWS();
		//TODO: add converter

		return orderWS;
	}

	/**
	 * Converts OrderWS instance to Order instance
	 * @param orderWS
	 * @return
	 */
	public static Order toModel(OrderWS orderWS) {
		Order order = new Order();
		//TODO: add converter

		return order;
	}
}

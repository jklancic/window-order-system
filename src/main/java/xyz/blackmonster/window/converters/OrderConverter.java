package xyz.blackmonster.window.converters;

import java.util.stream.Collectors;

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
		orderWS.setWindows(order.getWindows().stream().map(WindowConverter::toWS).collect(Collectors.toList()));
		orderWS.setService(ServiceConverter.toWS(order.getService()));
		orderWS.setEmail(order.getEmail());

		return orderWS;
	}

	/**
	 * Converts OrderWS instance to Order instance
	 * @param orderWS
	 * @return
	 */
	public static Order toModel(OrderWS orderWS) {
		Order order = new Order();
		order.setWindows(orderWS.getWindows().stream().map(WindowConverter::toModel).collect(Collectors.toList()));
		order.setService(ServiceConverter.toModel(orderWS.getService()));
		order.setEmail(orderWS.getEmail());

		return order;
	}
}

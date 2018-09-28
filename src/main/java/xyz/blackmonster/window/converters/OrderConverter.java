package xyz.blackmonster.window.converters;

import java.util.stream.Collectors;

import xyz.blackmonster.window.models.WindowOrder;
import xyz.blackmonster.window.responses.OrderWS;

/**
 * Converts WS order objects from and to order models
 */
public class OrderConverter {

	/**
	 * Converts WindowOrder instance to OrderWS instance
	 * @param windowOrder
	 * @return
	 */
	public static OrderWS toWS(WindowOrder windowOrder) {
		OrderWS orderWS = new OrderWS();
		orderWS.setWindows(windowOrder.getWindows().stream().map(WindowConverter::toWS).collect(Collectors.toList()));
		orderWS.setService(ServiceConverter.toWS(windowOrder.getService()));
		orderWS.setEmail(windowOrder.getEmail());

		return orderWS;
	}

	/**
	 * Converts OrderWS instance to WindowOrder instance
	 * @param orderWS
	 * @return
	 */
	public static WindowOrder toModel(OrderWS orderWS) {
		WindowOrder windowOrder = new WindowOrder();
		windowOrder.setWindows(orderWS.getWindows().stream().map(WindowConverter::toModel).collect(Collectors.toList()));
		windowOrder.setService(ServiceConverter.toModel(orderWS.getService()));
		windowOrder.setEmail(orderWS.getEmail());

		return windowOrder;
	}
}

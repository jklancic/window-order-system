package xyz.blackmonster.window.converters;

import java.util.stream.Collectors;

import xyz.blackmonster.window.models.WindowOrder;
import xyz.blackmonster.window.responses.OrderWS;

/**
 * Converts WS order objects from and to order models
 */
public class OrderConverter {

	/**
	 * Converts OrderWS instance to WindowOrder instance
	 * @param orderWS
	 * @return
	 */
	public static WindowOrder toModel(OrderWS orderWS) {
		WindowOrder windowOrder = new WindowOrder();
		windowOrder.setWindows(orderWS.getWindows().stream().map(WindowConverter::toModel).collect(Collectors.toList()));
		windowOrder.setServices(ServiceConverter.toModel(orderWS.getService()));
		windowOrder.setEmail(orderWS.getEmail());

		return windowOrder;
	}
}

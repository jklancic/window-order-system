package xyz.blackmonster.window.pages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xyz.blackmonster.window.responses.OrderWS;
import xyz.blackmonster.window.services.OrderService;

@RestController
@RequestMapping("api/order")
public class OrderRestController {

	private OrderService orderService;

	@Autowired
	public OrderRestController(OrderService orderService) {
		this.orderService = orderService;
	}

	@RequestMapping("calculate")
	public OrderWS calculateCost(@RequestBody OrderWS orderWS) {
		return orderService.calculate(orderWS);
	}

	@RequestMapping("sent")
	public void sentOrder(@RequestBody OrderWS orderWS) {
		//TODO: save order, create PDF and sent it
	}
}

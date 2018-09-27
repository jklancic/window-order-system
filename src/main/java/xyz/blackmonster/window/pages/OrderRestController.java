package xyz.blackmonster.window.pages;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import xyz.blackmonster.window.responses.CostWS;
import xyz.blackmonster.window.responses.OrderWS;
import xyz.blackmonster.window.services.OrderService;

@RestController
@RequestMapping("/api/order")
public class OrderRestController {

	private OrderService orderService;

	@Autowired
	public OrderRestController(OrderService orderService) {
		this.orderService = orderService;
	}

	@PostMapping("/calculate")
	public CostWS calculateCost(@Valid @RequestBody OrderWS orderWS) {
		return orderService.calculate(orderWS);
	}

	@PostMapping("/send")
	@ResponseStatus(value = HttpStatus.OK)
	public void sentOrder(@Valid @RequestBody OrderWS orderWS) {
		orderService.saveAndSentOrder(orderWS);
	}
}

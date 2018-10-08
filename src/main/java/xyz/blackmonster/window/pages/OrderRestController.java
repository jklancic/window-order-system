package xyz.blackmonster.window.pages;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import xyz.blackmonster.window.converters.CostConverter;
import xyz.blackmonster.window.converters.OrderConverter;
import xyz.blackmonster.window.models.Cost;
import xyz.blackmonster.window.responses.rest.CostWS;
import xyz.blackmonster.window.responses.rest.OrderWS;
import xyz.blackmonster.window.services.CostService;
import xyz.blackmonster.window.services.OrderService;

@RestController
@RequestMapping("/api/order")
public class OrderRestController {

	private final OrderService orderService;

	private final CostService costService;

	@Autowired
	public OrderRestController(OrderService orderService, CostService costService) {
		this.orderService = orderService;
		this.costService = costService;
	}

	@PostMapping("/calculate")
	public CostWS calculateCost(@Valid @RequestBody OrderWS orderWS) {
		Cost cost = costService.calcAll(OrderConverter.toModel(orderWS), false);
		return CostConverter.toWS(cost);
	}

	@PostMapping("/send")
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<String> sentOrder(@Valid @RequestBody OrderWS orderWS) {
		if (orderWS.getEmail() == null || orderWS.getEmail().isEmpty()) {
			return new ResponseEntity<>("Email is needed", HttpStatus.BAD_REQUEST);
		}
		orderService.saveAndSentOrder(OrderConverter.toModel(orderWS));
		return new ResponseEntity<>("Order will be sent", HttpStatus.OK);
	}
}

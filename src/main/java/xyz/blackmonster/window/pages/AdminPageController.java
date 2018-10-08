package xyz.blackmonster.window.pages;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import xyz.blackmonster.window.models.WindowOrder;
import xyz.blackmonster.window.responses.mvc.OrderItem;
import xyz.blackmonster.window.responses.mvc.OrderListItem;
import xyz.blackmonster.window.services.OrderService;

@Controller
@RequestMapping("/admin")
public class AdminPageController {

	private final OrderService orderService;

	@Autowired
	public AdminPageController(OrderService orderService) {
		this.orderService = orderService;
	}

	@RequestMapping("/orders")
	public String orderList(Model model) {
		List<OrderListItem> list = orderService.listLastOrders().stream().map(OrderListItem::new).collect(Collectors.toList());
		model.addAttribute("orders", list);
		return "orders";
	}

	@RequestMapping("/orders/{uuid}")
	public String order(@PathVariable("uuid") String uuid, Model model) {
		OrderItem order = orderService.retrieveOrder(uuid).map(OrderItem::new).orElse(null);
		model.addAttribute("order", order);
		return "order";
	}
}

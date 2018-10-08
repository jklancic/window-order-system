package xyz.blackmonster.window.services;

import java.util.List;
import java.util.Optional;

import xyz.blackmonster.window.models.WindowOrder;

public interface OrderService {

	void saveAndSentOrder(WindowOrder windowOrder);
	List<WindowOrder> listLastOrders();
	Optional<WindowOrder> retrieveOrder(String uuid);
}

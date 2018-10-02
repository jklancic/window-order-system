package xyz.blackmonster.window.services;

import xyz.blackmonster.window.models.WindowOrder;

public interface OrderService {

	void saveAndSentOrder(WindowOrder windowOrder);
}

package xyz.blackmonster.window.services;

import xyz.blackmonster.window.models.Cost;
import xyz.blackmonster.window.models.WindowService;
import xyz.blackmonster.window.models.Window;
import xyz.blackmonster.window.models.WindowOrder;

public interface CostService {

	double calcWindowPrice(Window window);
	double calcServicePrice(WindowService windowService, double baseCost);
	double calcTax(double baseCost);
	Cost calcAll(WindowOrder windowOrder, boolean saveOrder);
}

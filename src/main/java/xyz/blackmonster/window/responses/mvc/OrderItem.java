package xyz.blackmonster.window.responses.mvc;

import java.util.List;

import xyz.blackmonster.window.models.Window;
import xyz.blackmonster.window.models.WindowOrder;
import xyz.blackmonster.window.models.WindowService;

public class OrderItem {

	private List<Window> windows;
	private List<WindowService> services;
	private String email;
	private String orderNumber;
	private double valueAddedTaxPercentage;
	private double windowCost;
	private double serviceCost;
	private double totalCost;

	public OrderItem(WindowOrder windowOrder) {
		this.windows = windowOrder.getWindows();
		this.services = windowOrder.getServices();
		this.email = windowOrder.getEmail();
		this.orderNumber = windowOrder.getOrderNumber();
		this.valueAddedTaxPercentage = windowOrder.getValueAddedTaxPercentage();
		this.windowCost = windowOrder.getWindowCost();
		this.serviceCost = windowOrder.getServiceCost();
		this.totalCost = windowOrder.getTotalCost();
	}

	public List<Window> getWindows() {
		return windows;
	}

	public List<WindowService> getServices() {
		return services;
	}

	public String getEmail() {
		return email;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public double getValueAddedTaxPercentage() {
		return valueAddedTaxPercentage;
	}

	public double getWindowCost() {
		return windowCost;
	}

	public double getServiceCost() {
		return serviceCost;
	}

	public double getTotalCost() {
		return totalCost;
	}
}

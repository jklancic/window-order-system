package xyz.blackmonster.window.responses.mvc;

import xyz.blackmonster.window.models.WindowOrder;

public class OrderListItem {

	private String uuid;
	private String orderNumber;
	private double windowCost;
	private double serviceCost;
	private double totalCost;

	public OrderListItem(WindowOrder windowOrder) {
		this.uuid = windowOrder.getUuid();
		this.orderNumber = windowOrder.getOrderNumber();
		this.windowCost = windowOrder.getWindowCost();
		this.serviceCost = windowOrder.getServiceCost();
		this.totalCost = windowOrder.getTotalCost();
	}

	public String getUuid() {
		return uuid;
	}

	public String getOrderNumber() {
		return orderNumber;
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

package xyz.blackmonster.window.responses;

import java.util.List;

/**
 * Rest response body for order
 */
public class OrderWS {

	private List<WindowWS> windows;
	private ServiceWS service;
	private CostWS cost;
	private String email;

	public List<WindowWS> getWindows() {
		return windows;
	}

	public void setWindows(List<WindowWS> windows) {
		this.windows = windows;
	}

	public ServiceWS getService() {
		return service;
	}

	public void setService(ServiceWS service) {
		this.service = service;
	}

	public CostWS getCost() {
		return cost;
	}

	public void setCost(CostWS cost) {
		this.cost = cost;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}

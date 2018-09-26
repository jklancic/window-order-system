package xyz.blackmonster.window.responses;

import java.util.List;

import javax.validation.constraints.NotNull;

/**
 * Rest response body for order
 */
public class OrderWS {

	@NotNull
	private List<WindowWS> windows;
	@NotNull
	private ServiceWS service;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}

package xyz.blackmonster.window.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

/**
 * Window order
 */
@Entity
public class WindowOrder {

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid2")
	private String uuid;
	@OneToMany(mappedBy = "windowOrder", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Window> windows;
	@OneToMany(mappedBy = "windowOrder", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<WindowService> services;
	@Column(name = "email")
	private String email;
	@Column(name = "order_number")
	private String orderNumber;
	@Column(name = "value_added_tax")
	private double valueAddedTaxPercentage;
	@Column(name = "window_cost")
	private double windowCost;
	@Column(name = "service_cost")
	private double serviceCost;
	@Column(name = "total_cost")
	private double totalCost;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public List<Window> getWindows() {
		return windows;
	}

	public void setWindows(List<Window> windows) {
		this.windows = windows;
	}

	public List<WindowService> getServices() {
		return services;
	}

	public void setServices(List<WindowService> services) {
		this.services = services;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public double getValueAddedTaxPercentage() {
		return valueAddedTaxPercentage;
	}

	public void setValueAddedTaxPercentage(double valueAddedTaxPercentage) {
		this.valueAddedTaxPercentage = valueAddedTaxPercentage;
	}

	public double getWindowCost() {
		return windowCost;
	}

	public void setWindowCost(double windowCost) {
		this.windowCost = windowCost;
	}

	public double getServiceCost() {
		return serviceCost;
	}

	public void setServiceCost(double serviceCost) {
		this.serviceCost = serviceCost;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
}

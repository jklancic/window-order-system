package xyz.blackmonster.window.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
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
	@Generated(GenerationTime.INSERT)
	@Column(name = "order_number", insertable = false)
	private long orderNumber;
	@Column(name = "value_added_tax")
	private double valueAddedTaxPercentage;

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

	public long getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(long orderNumber) {
		this.orderNumber = orderNumber;
	}

	public double getValueAddedTaxPercentage() {
		return valueAddedTaxPercentage;
	}

	public void setValueAddedTaxPercentage(double valueAddedTaxPercentage) {
		this.valueAddedTaxPercentage = valueAddedTaxPercentage;
	}
}

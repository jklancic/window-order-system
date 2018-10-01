package xyz.blackmonster.window.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

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
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "windowOrder", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Window> windows;
	@OneToOne(fetch = FetchType.EAGER, mappedBy = "windowOrder", cascade = CascadeType.ALL, orphanRemoval = true)
	private Service service;
	@OneToOne(fetch = FetchType.EAGER, mappedBy = "windowOrder", cascade = CascadeType.ALL, orphanRemoval = true)
	private Cost cost;
	@Column(name = "email")
	private String email;
	@Generated(GenerationTime.INSERT)
	@Column(name = "order_number", insertable = false)
	private long orderNumber;

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

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public Cost getCost() {
		return cost;
	}

	public void setCost(Cost cost) {
		this.cost = cost;
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
}

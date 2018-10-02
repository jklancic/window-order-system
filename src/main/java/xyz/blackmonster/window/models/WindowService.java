package xyz.blackmonster.window.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

import xyz.blackmonster.window.types.ServiceType;

/**
 * Window service
 */
@Entity
public class WindowService {

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid2")
	private String uuid;
	@Column(name = "type")
	private ServiceType type;
	@Column(name = "distance")
	private int distance;
	@Column(name = "cost")
	private double cost;
	@ManyToOne
	@JoinColumn(name = "order_uuid", nullable = false)
	private WindowOrder windowOrder;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public ServiceType getType() {
		return type;
	}

	public void setType(ServiceType type) {
		this.type = type;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public WindowOrder getWindowOrder() {
		return windowOrder;
	}

	public void setWindowOrder(WindowOrder windowOrder) {
		this.windowOrder = windowOrder;
	}
}

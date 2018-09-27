package xyz.blackmonster.window.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

/**
 * Window service
 */
@Entity
public class Service {

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid2")
	private String uuid;
	@Column(name = "deinstallation")
	private boolean deinstallation;
	@Column(name = "disposal")
	private boolean disposal;
	@Column(name = "shipping")
	private boolean shipping;
	@Column(name = "installation")
	private boolean installation;
	@Column(name = "finalization")
	private boolean finalization;
	@Column(name = "distance")
	private int distance;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public boolean isDeinstallation() {
		return deinstallation;
	}

	public void setDeinstallation(boolean deinstallation) {
		this.deinstallation = deinstallation;
	}

	public boolean isDisposal() {
		return disposal;
	}

	public void setDisposal(boolean disposal) {
		this.disposal = disposal;
	}

	public boolean isShipping() {
		return shipping;
	}

	public void setShipping(boolean shipping) {
		this.shipping = shipping;
	}

	public boolean isInstallation() {
		return installation;
	}

	public void setInstallation(boolean installation) {
		this.installation = installation;
	}

	public boolean isFinalization() {
		return finalization;
	}

	public void setFinalization(boolean finalization) {
		this.finalization = finalization;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}
}

package xyz.blackmonster.window.responses;

import javax.validation.constraints.NotNull;

/**
 * Rest response body for window service
 */
public class ServiceWS {

	@NotNull
	private boolean deinstallation;
	@NotNull
	private boolean disposal;
	@NotNull
	private boolean shipping;
	@NotNull
	private boolean installation;
	@NotNull
	private boolean finalization;
	private int distance;

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

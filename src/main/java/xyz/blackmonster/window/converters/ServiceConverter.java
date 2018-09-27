package xyz.blackmonster.window.converters;

import xyz.blackmonster.window.models.Service;
import xyz.blackmonster.window.responses.ServiceWS;

/**
 * Converts WS service objects from and to service models
 */
public class ServiceConverter {

	/**
	 * Converts Service instance to ServiceWS instance
	 * @param service
	 * @return
	 */
	public static ServiceWS toWS(Service service) {
		ServiceWS serviceWS = new ServiceWS();
		serviceWS.setDeinstallation(service.isDeinstallation());
		serviceWS.setDisposal(service.isDisposal());
		serviceWS.setShipping(service.isShipping());
		serviceWS.setInstallation(service.isInstallation());
		serviceWS.setFinalization(service.isFinalization());
		serviceWS.setDistance(service.getDistance());

		return serviceWS;
	}

	/**
	 * Converts ServiceWS instance to Service instance
	 * @param serviceWS
	 * @return
	 */
	public static Service toModel(ServiceWS serviceWS) {
		Service service = new Service();
		service.setDeinstallation(serviceWS.isDeinstallation());
		service.setDisposal(serviceWS.isDisposal());
		service.setShipping(serviceWS.isShipping());
		service.setInstallation(serviceWS.isInstallation());
		service.setFinalization(serviceWS.isFinalization());
		service.setDistance(serviceWS.getDistance());

		return service;
	}
}

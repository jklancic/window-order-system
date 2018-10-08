package xyz.blackmonster.window.converters;

import java.util.ArrayList;
import java.util.List;

import xyz.blackmonster.window.models.WindowService;
import xyz.blackmonster.window.responses.rest.ServiceWS;
import xyz.blackmonster.window.types.ServiceType;

/**
 * Converts WS service objects from and to service models
 */
public class ServiceConverter {

	/**
	 * Converts ServiceWS instance to WindowService instance
	 * @param serviceWS
	 * @return
	 */
	public static List<WindowService> toModel(ServiceWS serviceWS) {
		List<WindowService> services = new ArrayList<>();

		if(serviceWS.isDeinstallation()) {
			services.add(createNewService(ServiceType.DEINSTALLATION));
		}

		if(serviceWS.isDisposal()) {
			services.add(createNewService(ServiceType.DISPOSAL));
		}

		if(serviceWS.isShipping()) {
			WindowService service = createNewService(ServiceType.DISPOSAL);
			service.setDistance(serviceWS.getDistance());
			services.add(service);
		}

		if(serviceWS.isInstallation()) {
			services.add(createNewService(ServiceType.INSTALLATION));
		}

		if(serviceWS.isFinalization()) {
			services.add(createNewService(ServiceType.FINALIZATION));
		}

		return services;
	}

	private static WindowService createNewService(ServiceType serviceType) {
		WindowService service = new WindowService();
		service.setType(serviceType);

		return service;
	}
}

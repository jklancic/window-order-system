package xyz.blackmonster.window.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import xyz.blackmonster.window.models.ServicePrice;
import xyz.blackmonster.window.types.ServiceType;

public interface ServicePriceRepository extends JpaRepository<ServicePrice, String> {

	ServicePrice findByType(ServiceType serviceType);
}

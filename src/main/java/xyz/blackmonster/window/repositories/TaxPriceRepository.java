package xyz.blackmonster.window.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import xyz.blackmonster.window.models.TaxPrice;
import xyz.blackmonster.window.types.TaxType;

public interface TaxPriceRepository extends JpaRepository<TaxPrice, String> {

	TaxPrice findByType(TaxType taxType);
}

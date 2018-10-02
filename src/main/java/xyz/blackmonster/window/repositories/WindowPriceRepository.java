package xyz.blackmonster.window.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import xyz.blackmonster.window.models.WindowPrice;
import xyz.blackmonster.window.types.WindowType;

public interface WindowPriceRepository extends JpaRepository<WindowPrice, String> {

	WindowPrice findByType(WindowType windowType);
}

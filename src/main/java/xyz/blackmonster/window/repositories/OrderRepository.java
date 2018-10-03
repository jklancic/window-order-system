package xyz.blackmonster.window.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import xyz.blackmonster.window.models.WindowOrder;

public interface OrderRepository extends JpaRepository<WindowOrder, String> {

	@Query("SELECT COUNT(o) FROM WindowOrder o WHERE o.orderNumber LIKE :sequence")
	long countTodaysOrders(@Param("sequence") String sequence);
}

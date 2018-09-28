package xyz.blackmonster.window.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import xyz.blackmonster.window.models.WindowOrder;

public interface OrderRepository extends JpaRepository<WindowOrder, String> {
}

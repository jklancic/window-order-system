package xyz.blackmonster.window.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import xyz.blackmonster.window.models.Order;

public interface OrderRepository extends JpaRepository<Order, String> {
}

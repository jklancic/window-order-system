package xyz.blackmonster.window.repositories;

import org.springframework.data.repository.CrudRepository;

import xyz.blackmonster.window.models.Order;

public interface OrderRepositoriy extends CrudRepository<Order, String> {
}

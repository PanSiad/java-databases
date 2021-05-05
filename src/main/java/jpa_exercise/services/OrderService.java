package jpa_exercise.services;

import jpa_exercise.model.Order;

import javax.persistence.EntityManager;
import java.util.List;

public class OrderService {

    private final EntityManager entityManager;

    public OrderService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //TODO implement the save
    public Order save(Order order) {
        return null;
    }

    //TODO implement findAllOrders
    public List<Order> findAllOrders() {
        return null;
    }

    //TODO implement updateOrderPrice
    public Order updateOrderPrice(Double newPrice) {
        return null;
    }

    //TODO implement deleteOrder
    public void deleteOrder(Order order) {

    }

}

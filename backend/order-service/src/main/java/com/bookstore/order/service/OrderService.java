package com.bookstore.order.service;

import com.bookstore.order.model.Order;
import com.bookstore.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repo;

    public List<Order> getAll() {
        return repo.findAll();
    }

    public Order save(Order order) {
        return repo.save(order);
    }
}
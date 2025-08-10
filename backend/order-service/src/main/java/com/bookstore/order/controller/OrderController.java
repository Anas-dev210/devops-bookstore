package com.bookstore.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bookstore.order.model.Order;

import com.bookstore.order.dto.OrderDTO;
import com.bookstore.order.service.OrderService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {

    @Autowired
    private OrderService service;

    @GetMapping
    public ResponseEntity<List<OrderDTO>> getAll() {
        List<Order> orders = service.getAll();
        List<OrderDTO> dtos = orders.stream().map(order -> {
            OrderDTO dto = new OrderDTO();
            dto.setId(order.getId());
            dto.setUserId(order.getUserId());
            dto.setBookId(order.getBookId());
            dto.setStatus(order.getStatus());
            return dto;
        }).toList();

        return ResponseEntity.ok(dtos);
    }

    @PostMapping
    public ResponseEntity<OrderDTO> create(@Valid @RequestBody OrderDTO dto) {
        Order order = new Order();
        order.setUserId(dto.getUserId());
        order.setBookId(dto.getBookId());

        Order saved = service.save(order);

        OrderDTO response = new OrderDTO();
        response.setId(saved.getId());
        response.setUserId(saved.getUserId());
        response.setBookId(saved.getBookId());
        response.setStatus(saved.getStatus());

        return ResponseEntity.ok(response);
    }
}
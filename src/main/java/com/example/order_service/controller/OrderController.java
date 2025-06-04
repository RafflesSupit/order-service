package com.example.order_service.controller;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.order_service.model.Order;
import com.example.order_service.repository.OrderRepository;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderRepository ors;

    @GetMapping
    public List<Order> findAll(){
        try {
            return ors.findAll();
        } catch (Exception e) {
            System.out.println(e);
        }
        return Collections.emptyList();
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order){
        try {
            return ors.save(order);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @GetMapping("/id")
    public Optional<Order> findById(@RequestParam String id){
        return ors.findById(id);
    }
}

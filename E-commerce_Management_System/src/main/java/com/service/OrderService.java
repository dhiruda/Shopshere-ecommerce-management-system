package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Order;
import com.repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    OrderRepository orepo;

    // Save order
    public Order saveOrder(Order order) {
        return orepo.save(order);
    }

    // Get all orders
    public List<Order> getAllOrders() {
        return orepo.findAll();
    }

    // Get order by id
    public Order getOrderById(int oid) {
        return orepo.findById(oid).orElse(null);
    }

    // Delete order
    public void deleteOrder(int oid) {
        orepo.deleteById(oid);
    }

    // Find orders by user
    public List<Order> getOrdersByUser(int eid){
        return orepo.findByUserEid(eid);
    }

    // Find orders by product
    public List<Order> getOrdersByProduct(int pid){
        return orepo.findByProductPid(pid);
    }

}
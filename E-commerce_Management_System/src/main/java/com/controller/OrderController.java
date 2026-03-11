package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.entity.Order;
import com.service.OrderService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderService oserv;

    // Create order
    @PostMapping("/save")
    public Order saveOrder(@RequestBody Order order) {
        return oserv.saveOrder(order);
    }

    // Get all orders
    @GetMapping("/all")
    public List<Order> getAllOrders(){
        return oserv.getAllOrders();
    }

    // Get order by id
    @GetMapping("/{oid}")
    public Order getOrderById(@PathVariable int oid){
        return oserv.getOrderById(oid);
    }

    // Delete order
    @DeleteMapping("/delete/{oid}")
    public String deleteOrder(@PathVariable int oid){
        oserv.deleteOrder(oid);
        return "Order Deleted";
    }

    // Orders by user
    @GetMapping("/user/{eid}")
    public List<Order> ordersByUser(@PathVariable int eid){
        return oserv.getOrdersByUser(eid);
    }

    // Orders by product
    @GetMapping("/product/{pid}")
    public List<Order> ordersByProduct(@PathVariable int pid){
        return oserv.getOrdersByProduct(pid);
    }
}
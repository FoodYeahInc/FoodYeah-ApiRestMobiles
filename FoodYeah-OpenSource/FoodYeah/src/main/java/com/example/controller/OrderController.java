package com.example.controller;

import com.example.entity.Order;
import com.example.service.OrderService;
import com.example.util.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<Order>> listAllOrders(@RequestParam(name = "orderId", required =  false) Long orderId){
        List<Order> orders = new ArrayList<>();
        if(null == orderId){
            orders = orderService.findOrderAll();
            if(orders.isEmpty()){
                return ResponseEntity.noContent().build();
            }
        }
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable("id") long id){
        log.info("Fetching Orders with Id {}", id);
        Order order = orderService.getOrder(id);
        if(null == order){
            log.error("Order with id {} not found.",id);
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(order);
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@Valid @RequestBody Order order, BindingResult result){
        log.info("Creating Order : {}", order);
        if(result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Message.formatMessage(result));
        }
        Order orderDB = orderService.createOrder(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(orderDB);
    }
}

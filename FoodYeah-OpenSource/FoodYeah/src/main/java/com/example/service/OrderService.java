package com.example.service;

import com.example.entity.Order;
import com.example.entity.OrderDetail;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public interface OrderService {
    List<Order> findOrderAll();
    Order getOrder(Long id);
    Order createOrder(Order order);
    void SetEndTime(Order order);
    void DecreaseStock(Order order);
    String GetAverageTime();
}

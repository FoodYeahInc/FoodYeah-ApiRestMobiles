package com.example.service;

import com.example.entity.Order;

import java.util.List;

public interface OrderService {

    List<Order> findOrderAll();
    Order getOrder(Long id);
    Order createOrder(Order order);
    //TODO: Siento que faltaría un modificar por si ocurren cambios en las ordenes
    //O un rico delete, por si el sistema pasa mal los datos
}

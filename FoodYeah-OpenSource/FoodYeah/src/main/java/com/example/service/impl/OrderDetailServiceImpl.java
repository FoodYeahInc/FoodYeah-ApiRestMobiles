package com.example.service.impl;

import com.example.entity.OrderDetail;
import com.example.repository.OrderDetailRepository;
import com.example.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    public OrderDetailServiceImpl(OrderDetailRepository orderDetailRepository){
        this.orderDetailRepository=orderDetailRepository;
    }
    @Override
    public List<OrderDetail> findOrderDetailAll() {
        return orderDetailRepository.findAll();
    }

    @Override
    public OrderDetail getOrderDetail(Long id) {
        return orderDetailRepository.findById(id).orElse(null);
    }

    @Override
    public OrderDetail createOrderDetail(OrderDetail orderDetail) {
        OrderDetail orderDetailDB=this.getOrderDetail(orderDetail.getId());
        if(orderDetailDB!=null){
            return orderDetailDB;
        }
        orderDetailDB.setState("CREATED");
        orderDetailDB=orderDetailRepository.save(orderDetail);
        return orderDetailDB;
    }

    @Override
    public OrderDetail updateOrderDetail(OrderDetail orderDetail) {
        OrderDetail orderDetailDB=this.getOrderDetail(orderDetail.getId());
        if(orderDetailDB==null){
            return null;
        }
        orderDetailDB.setOrder(orderDetail.getOrder());
        orderDetailDB.setProduct(orderDetail.getProduct());
        orderDetailDB.setQuantity(orderDetail.getQuantity());
        //TODO .setTotalPrice


        orderDetailDB.setState("UPDATED");
        orderDetailDB=orderDetailRepository.save(orderDetail);
        return orderDetailDB;
    }

    @Override
    public OrderDetail deleteOrderDetail(Long id) {
        OrderDetail orderDetailDB=this.getOrderDetail(id);
        if(orderDetailDB==null){
            return null;
        }
        orderDetailDB.setState("DELETED");
        return orderDetailRepository.save(orderDetailDB);
    }
}

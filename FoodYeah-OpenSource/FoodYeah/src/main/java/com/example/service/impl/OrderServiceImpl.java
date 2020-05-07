package com.example.service.impl;

import com.example.entity.Order;
import com.example.entity.OrderDetail;
import com.example.entity.Product;
import com.example.repository.OrderDetailRepository;
import com.example.repository.OrderRepository;
import com.example.repository.ProductRepository;
import com.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    private OrderDetailRepository orderDetailRepository;
    private ProductRepository productRepository;

    @Override
    public List<Order> findOrderAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrder(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public Order createOrder(Order order) {

        order.setState("CREATED");
        return orderRepository.save(order);
    }

    private void PrepareDetail(List<OrderDetail> orderDetails){
        for (OrderDetail orderDetail: orderDetails
             ) {
            Product product = productRepository.getOne(orderDetail.getProduct().getId());
            orderDetail.setUnitPrice(product.getProductPrice());
            orderDetail.setTotalPrice(orderDetail.getUnitPrice() * orderDetail.getQuantity());
        }
    }

    private void PrepareHeader(Order order){
        order.setDate(new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
        order.setTotalPrice(OrderTotalPrice(order.getId()));
        order.setInittime(new SimpleDateFormat("HH:mm:ss").format(new Date()));
        order.setEndtime("00:00:00");
    }

    public void SetEndTime(Order order){
        order.setEndtime(new SimpleDateFormat("HH:mm:ss").format(new Date()));
    }

    public void DecreaseStock(Order order){
        List<OrderDetail> orderDetails = orderDetailRepository.findAllByOrderId(order.getId());
        for (OrderDetail orderDetail: orderDetails
             ) {
            orderDetail.getProduct().setStock((byte) (orderDetail.getProduct().getStock() - orderDetail.getQuantity()));
        }
    }

    public String GetAverageTime(){
        String s = "00:00:00";
        Long averageTime = 0L;
        int quant = 0;
        for (Order order: orderRepository.findAll()
             ) {
            if(order.getEndtime() == "00:00:00")
                continue;
            quant++;
            Long _inittime = new SimpleDateFormat("HH:mm:ss").parse(order.getInittime(), new ParsePosition(0)).getTime();
            Long _endtime = new SimpleDateFormat("HH:mm:ss").parse(order.getEndtime(), new ParsePosition(0)).getTime();
            averageTime += _endtime - _inittime;
        }
        if(quant == 0)
            return ("00:05:00");
        averageTime /= quant;
        Long hours = (averageTime/3600);
        Long mins = (averageTime - (hours*3600));
        Long secs = (averageTime - (mins*60) - (hours*3600));
        String Avg = (hours.toString() + mins.toString() + secs.toString());
        return Avg;

    }

    public float OrderTotalPrice (long Id){
        float TotalPrice = 0;
        List<OrderDetail> orderDetails = orderDetailRepository.findAllByOrderId(Id);
        for (OrderDetail orderDetail: orderDetails
             ) {
            TotalPrice += orderDetail.getTotalPrice();
        }
        return TotalPrice;
    }
}

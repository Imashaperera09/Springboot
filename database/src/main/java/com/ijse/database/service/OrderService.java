package com.ijse.database.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ijse.database.entity.Order;

@Service
public interface OrderService {
   List<Order> getAllOrders();
   Order createOrder(OrderDTO OrderDTO);
   Order getOrderById(Long id);
}

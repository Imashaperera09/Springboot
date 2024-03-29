package com.ijse.database.service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;  // Add this import

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijse.database.entity.Item;  // Add this import
import com.ijse.database.entity.Order;
import com.ijse.database.repository.ItemRepository;
import com.ijse.database.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {
    
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    @Override
    public Order createOrder(OrderDTO orderDTO) {
        List<Long> itemIds = orderDTO.getItem();

        Set<Item> items = new HashSet<>();

        Double total = 0.0;

        for (Long itemId : itemIds) {
            Item item = itemRepository.findById(itemId).orElse(null);

            if(item != null) {
                //add this to the Item set
                items.add(item);
                total = total + item.getPrice();

                item.setQuantity(item.getQuantity()-1);
                itemRepository.save(item);
            }
        }

        Double tax = (total / 100) * 15;
        LocalDateTime dateTime = LocalDateTime.now();

        Order order = new Order();
        order.setTotal(total);
        order.setTax(tax);
        order.setDateTime(dateTime);
        order.setItems(items);

        return orderRepository.save(order);
    }

    @Override
    public Order getOrderById(Long id){
        return orderRepository.findById(id).orElse(null);
    }
}















































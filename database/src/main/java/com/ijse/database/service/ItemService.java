package com.ijse.database.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ijse.database.dto.ItemDTO;
import com.ijse.database.entity.Item;

@Service
public interface ItemService {
      Item createItem(ItemDTO itemDTO); 
    List<Item> getAllItems();
     Item  getItemById(Long id);
    Item updateItem(Long id,Item item);
    List<Item> findByCategory(Long id);
}









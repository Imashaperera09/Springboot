package com.ijse.database.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ijse.database.dto.ItemDTO;
import com.ijse.database.entity.Item;
import com.ijse.database.service.ItemService;

@RestController
@CrossOrigin(origins = "*")
public class ItemController {
    
     @Autowired
    private ItemService itemService; 

     @PostMapping("/item")
    public ResponseEntity<Item> createItem(@RequestBody ItemDTO itemDTO){
            return ResponseEntity.status(201).body(itemService.createItem(itemDTO));
    }

    @GetMapping("/item")
    public List<Item> getAllItems(){
        return itemService.getAllItems();
    }
    @GetMapping("/item/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable Long id){
        Item item = itemService.getItemById(id);

        if(item !=null){
            return ResponseEntity.status(200).body(item);
            //return item with 200 OK code
        }else{
            return ResponseEntity.status(404).body(null);
            //return 404 Error
        }
    }
       


@GetMapping("/category/{id}/item")
public List<Item> findByCategory(@PathVariable Long id){
    return itemService.findByCategory(id);
}
}


























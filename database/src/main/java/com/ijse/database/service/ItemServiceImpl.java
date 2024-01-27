package com.ijse.database.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijse.database.dto.ItemDTO;
import com.ijse.database.entity.Category;
import com.ijse.database.entity.Item;
import com.ijse.database.repository.CategoryRepository;
import com.ijse.database.repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService{
    @Autowired
    private ItemRepository itemRepository; 

    @Autowired
    private CategoryRepository categoryRepository;

    
    @Override
    public Item createItem(ItemDTO itemDTO){
        Category category = categoryRepository.findById(itemDTO.getCategoryId())
        .orElse(null);

            if(category != null){
                 Item item = new Item();
        item.setName(itemDTO.getName());
        item.setPrice(itemDTO.getPrice());
        item.setQuantity(itemDTO.getQty());
        item.setCategory(category);
        return itemRepository.save(item);
            }else{
                return null;
            
           }
}
    

     @Override
     public List<Item> getAllItems(){
        return itemRepository.findAll();
     }
     @Override
     public Item getItemById(Long id){
        return itemRepository.findById(id).orElse(null);
     }
    @Override
    public  Item updateItem(Long id, Item item){
            Item existingItem = itemRepository.findById(id).orElse(null);
          
        if(existingItem != null){
            existingItem.setName(item.getName());
            existingItem.setCategory(item.getCategory());
            existingItem.setPrice(item.getPrice());
            existingItem.setQuantity(item.getQuantity());
            return itemRepository.save(existingItem);
        }else{
            return null;
 }
}

@Override
public List<Item> findByCategory (Long id){
   Category category = categoryRepository.findById(id).orElse(null);
   
   if(category !=null){
    return itemRepository.findByCategory(category);
   }else{
    return null;
   }
}
}














   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   


   
   
   
   
   
   






   




























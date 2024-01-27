package com.ijse.database.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ijse.database.entity.Category;
import com.ijse.database.service.CategoryService;


@RestController
@CrossOrigin(origins = "*")
public class CategoryController {
    
    
    @Autowired
    private CategoryService userService;


 @PostMapping("/category")
 public Category createCategory(@RequestBody Category category) {
   return userService.createCategory(category);  
 }

 @GetMapping("/category")
public List<Category> getAllCategories() {
    return userService.getAllCategories();
}

@GetMapping("/category/{id}")
public Category getCategoryById(@PathVariable Long id){
    return userService.getCategoryById(id);
}

@PutMapping("/category")
public Category updateCategory(Long id, Category category){
    return userService.updateCategory(id, category);
}

}

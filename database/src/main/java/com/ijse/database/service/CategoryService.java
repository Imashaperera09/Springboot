package com.ijse.database.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ijse.database.entity.Category;


@Service
public interface CategoryService {
 Category createCategory (Category user); //create user method
 Category getCategoryById(Long id); //read user by user_id
 List<Category> getAllCategories(); //read all users
 Category updateCategory(Long id, Category category);

}

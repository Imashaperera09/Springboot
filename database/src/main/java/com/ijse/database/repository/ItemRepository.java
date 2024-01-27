package com.ijse.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ijse.database.entity.Category;
import com.ijse.database.entity.Item;
import java.util.List;


@Repository
public interface ItemRepository extends JpaRepository<Item,Long>{
    //CustomeQuery
    @Query("SELECT p FROM Item p WHERE p.category =:category")
    List<Item>findByCategory(@Param("category") Category category);
}

















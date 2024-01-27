package com.ijse.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ijse.database.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

   com.ijse.database.entity.User save(com.ijse.database.entity.User user);
   //Custom Queries 
}

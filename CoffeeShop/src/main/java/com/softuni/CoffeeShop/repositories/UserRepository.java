package com.softuni.CoffeeShop.repositories;

import com.softuni.CoffeeShop.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    Optional<User> findByEmail(String email);

    Optional<User> findByUsername(String username);

    Optional<User> findByUsernameAndPassword(String username, String password);

   // @Query("SELECT u FROM User u ORDER BY size(u.orders) DESC")
  //  List<User> findAllByOrdersCountDesc();
}

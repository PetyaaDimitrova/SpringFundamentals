package com.softuni.CoffeeShop.services;

import com.softuni.CoffeeShop.models.entity.User;
import com.softuni.CoffeeShop.models.service.UserServiceModel;
import com.softuni.CoffeeShop.models.view.UserViewModel;

import java.util.List;

public interface UserService {
    UserServiceModel registerUser(UserServiceModel userServiceModel);

    UserServiceModel findByUsernameAndPassword(String username, String password);

    void loginUser(Long id, String username);

    User findById(Long id);

    List<UserViewModel> findAllUserAndCountOfOrdersOrderByCountDesc();
}

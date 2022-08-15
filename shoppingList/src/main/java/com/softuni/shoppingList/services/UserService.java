package com.softuni.shoppingList.services;

import com.softuni.shoppingList.models.User;
import com.softuni.shoppingList.models.dtos.UserLoginDTO;
import com.softuni.shoppingList.models.dtos.UserRegistrationDTO;
import com.softuni.shoppingList.repositories.UserRepository;
import com.softuni.shoppingList.session.LoggedUser;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final LoggedUser userSession;

    public UserService(UserRepository userRepository, LoggedUser userSession) {
        this.userRepository = userRepository;
        this.userSession = userSession;
    }

    public boolean register(UserRegistrationDTO registrationDTO) {

        if (!registrationDTO.getPassword().equals(registrationDTO.getConfirmPassword())) {
            return false;
        }

        Optional<User> byEmail = this.userRepository.findByEmail(registrationDTO.getEmail());
        if(byEmail.isPresent()){
            return false;
        }

        Optional<User> byUsername = this.userRepository.findByUsername(registrationDTO.getUsername());
        if(byUsername.isPresent()){
            return false;
        }

        User user = new User();
        user.setUsername(registrationDTO.getUsername());
        user.setEmail(registrationDTO.getEmail());
        user.setPassword(registrationDTO.getPassword());

        this.userRepository.save(user);
        return true;
    }

    public boolean login(UserLoginDTO loginDTO) {
        Optional<User> byUsernameAndPassword = this.userRepository
                .findByUsernameAndPassword(loginDTO.getUsername(), loginDTO.getPassword());

        if(byUsernameAndPassword.isEmpty()){
            return false;
        }
        this.userSession.login(byUsernameAndPassword.get());
        return true;
    }

    public void logout() {
        this.userSession.logout();
    }

    public boolean isLoggedIn() {
        return this.userSession.getId() > 0;
    }

    public long getLoggedUserId() {
        return this.userSession.getId();
    }
}

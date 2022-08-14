package com.softuni.CoffeeShop.services;

import com.softuni.CoffeeShop.models.User;
import com.softuni.CoffeeShop.models.dto.UserLoginDTO;
import com.softuni.CoffeeShop.models.dto.UserRegistrationDTO;
import com.softuni.CoffeeShop.repositories.UserRepository;
import com.softuni.CoffeeShop.session.LoggedUser;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final LoggedUser userSession;

    public AuthService(UserRepository userRepository, LoggedUser userSession) {
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
        user.setFirstName(registrationDTO.getFirstName());
        user.setLastName(registrationDTO.getLastName());

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

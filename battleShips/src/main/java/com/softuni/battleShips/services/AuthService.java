package com.softuni.battleShips.services;

import com.softuni.battleShips.models.User;
import com.softuni.battleShips.models.dto.UserLoginDTO;
import com.softuni.battleShips.models.dto.UserRegistrationDTO;
import com.softuni.battleShips.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
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
        user.setUserName(registrationDTO.getUsername());
        user.setEmail(registrationDTO.getEmail());
        user.setPassword(registrationDTO.getPassword());
        user.setFullName(registrationDTO.getFullName());

        this.userRepository.save(user);
        return true;
    }

    public boolean login(UserLoginDTO loginDTO) {
        return true;
    }
}

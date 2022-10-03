package com.softuni.CarsBg.service;

import com.softuni.CarsBg.model.User;
import com.softuni.CarsBg.model.dto.UserLoginDTO;
import com.softuni.CarsBg.model.dto.UserRegisterDTO;
import com.softuni.CarsBg.repository.UserRepository;
import com.softuni.CarsBg.user.CurrentUser;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;
    private CurrentUser currentUser;
    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, CurrentUser currentUser, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.currentUser = currentUser;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean login(UserLoginDTO userLoginDTO){
        Optional<User> userOptional = this.userRepository.findByEmail(userLoginDTO.getUsername());
        if(userOptional.isEmpty()){
            return false;
        }

        var rawPassword = userLoginDTO.getPassword();
        var hashPassword = userOptional.get().getPassword();

        boolean success = passwordEncoder.matches(rawPassword, hashPassword);

        if(success){
            login(userOptional.get());
        } else {
            logout();
        }
        return success;
    }

    private void login(User user){
        currentUser.setLoggedIn(true).setName(user.getFirstName() + " " + user.getLastName());
    }
    public void logout(){
        currentUser.clear();
    }

    public void registerAndLogin(UserRegisterDTO userRegisterDTO) {
        User user = new User();
        user.setActive(true);
        user.setEmail(userRegisterDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userRegisterDTO.getPassword()));
        user.setFirstName(userRegisterDTO.getFirstName());
        user.setLastName(userRegisterDTO.getLastName());

        userRepository.save(user);
        login(user);
    }
}

package bg.softuni.mobilele.services;

import bg.softuni.mobilele.dto.UserLoginDTO;
import bg.softuni.mobilele.dto.UserRegisterDTO;
import bg.softuni.mobilele.model.entities.UserEntity;
import bg.softuni.mobilele.repositories.UserRepository;
import bg.softuni.mobilele.user.CurrentUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private Logger logger = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;
    private CurrentUser currentUser;
    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, CurrentUser currentUser,
                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.currentUser = currentUser;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerAndLogin(UserRegisterDTO userRegisterDTO){

        UserEntity newUser = new UserEntity().setActive(true).setEmail(userRegisterDTO.getEmail())
                .setFirstName(userRegisterDTO.getFirstName()).setLastName(userRegisterDTO.getLastName())
                .setPassword(passwordEncoder.encode(userRegisterDTO.getPassword()));

       newUser = userRepository.save(newUser);

        userLogin(newUser);

    }

    public boolean login(UserLoginDTO userLoginDTO) {
        Optional<UserEntity> optional = userRepository.findByEmail(userLoginDTO.getUsername());

        if (optional.isEmpty()) {
            logger.info("User with name [{}] not found", userLoginDTO.getUsername());
            return false;
        }
        var rawPassword = userLoginDTO.getPassword();
        var encodedPassword = optional.get().getPassword();

        boolean success = passwordEncoder.matches(rawPassword, encodedPassword);

        if (success) {
            userLogin(optional.get());
        } else {

        }
        return success;
    }

    public void logout() {
        currentUser.clear();
    }

    public void userLogin(UserEntity userEntity) {
        currentUser.setLogged(true).setName(userEntity.getFirstName() + " " + userEntity.getLastName());

    }
}

package bg.softuni.mobilelle.mobilelle.services;

import bg.softuni.mobilelle.mobilelle.dto.UserLoginDTO;
import bg.softuni.mobilelle.mobilelle.model.entities.UserEntity;
import bg.softuni.mobilelle.mobilelle.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private Logger logger = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean login(UserLoginDTO userLoginDTO) {
        Optional<UserEntity> optional = userRepository.findByEmail(userLoginDTO.getUsername());

        if (optional.isEmpty()) {
            logger.debug("User with name [{}] not found", userLoginDTO.getUsername());
            return false;
        }
        return optional.get().getPassword().equals(userLoginDTO.getPassword());
    }
}

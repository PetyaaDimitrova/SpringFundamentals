package bg.softuni.mobilele.model.mapper;

import bg.softuni.mobilele.model.dto.user.UserRegisterDTO;
import bg.softuni.mobilele.model.entity.UserEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-06T11:42:06+0300",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.1.jar, environment: Java 17.0.3 (Amazon.com Inc.)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserEntity userDtoToUserEntity(UserRegisterDTO registerDTO) {
        if ( registerDTO == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setEmail( registerDTO.getEmail() );
        userEntity.setPassword( registerDTO.getPassword() );
        userEntity.setFirstName( registerDTO.getFirstName() );
        userEntity.setLastName( registerDTO.getLastName() );

        userEntity.setActive( true );

        return userEntity;
    }
}

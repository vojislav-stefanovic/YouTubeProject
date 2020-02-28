package project.support;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import project.model.User;
import project.web.dto.UserDTO;

@Component
public class UserDTOtoUser implements Converter<UserDTO, User> {

    @Override
    public User convert(UserDTO userDTO) {

        return User.builder()
                .blocked(userDTO.getBlocked())
                .date(userDTO.getDate())
                .email(userDTO.getEmail())
                .firstName(userDTO.getFirstName())
                .lastName(userDTO.getLastName())
                .password(userDTO.getPassword())
                .userName(userDTO.getUserName())
                .userType(userDTO.getUserType())
                .description(userDTO.getDescription())
                .id(userDTO.getId())
                .build();
    }
}

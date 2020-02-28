package project.support;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import project.model.User;
import project.web.dto.UserDTO;

@Component
public class UserToUserDTO implements Converter<User, UserDTO> {

    @Override
    public UserDTO convert(User user) {

        return UserDTO.builder()
                .blocked(user.getBlocked())
                .date(user.getDate())
                .description(user.getDescription())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .id(user.getId())
                .lastName(user.getLastName())
                .password(user.getPassword())
                .userName(user.getUserName())
                .userType(user.getUserType())
                .build();
    }
}

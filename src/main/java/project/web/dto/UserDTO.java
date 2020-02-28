package project.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.model.User;
import project.model.UserType;

import javax.validation.constraints.Email;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {

    public UserDTO(User user){
        if (user != null) {
            this.id = user.getId();
            this.blocked = user.getBlocked();
            this.date = user.getDate();
            this.description = user.getDescription();
            this.email = user.getEmail();
            this.firstName = user.getFirstName();
            this.lastName = user.getLastName();
            this.userName = user.getUserName();
            this.password = user.getPassword();
            this.userType = user.getUserType();
        }
    }

    private Long id;
    private String userName;
    private String password;
    private String confirmedPassword;
    private String firstName;
    private String lastName;
    @Email
    private String email;
    private String description;
    private Date date;
    private UserType userType;
    private Boolean blocked;
}

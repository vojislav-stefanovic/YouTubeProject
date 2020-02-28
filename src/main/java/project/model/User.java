package project.model;

import lombok.*;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name="tbl_user")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {


    @Id
    @GeneratedValue
    @Column
    private Long id;
    @Column(nullable = false, unique = true)
    private String userName;
    @Column(nullable = false)
    private String password;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column(nullable = false)
    @Email
    private String email;
    @Column
    private String description;
    @Column(nullable = false)
    private Date date;
    @Column(nullable = false)
    private UserType userType;
    @Column(nullable = false)
    private Boolean blocked;

//    @OneToMany(mappedBy = "user")
//    private List<User> subscribers = new ArrayList<>();

//    @OneToMany(mappedBy = "user")
//    private List<LikeDislike> commentLikes = new ArrayList<>();
//
//    @OneToMany(mappedBy = "user")
//    private List<LikeDislike> videoLikes = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Video> videos = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Comment> comments = new ArrayList<>();

}

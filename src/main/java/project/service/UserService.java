package project.service;

import project.model.User;
import project.model.Video;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findAll();

    Optional<User> findById(Long id);

    Optional<User> deleteById(Long id);

    User save(User user);

}

package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.model.User;
import project.model.Video;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


}

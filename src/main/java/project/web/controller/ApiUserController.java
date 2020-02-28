package project.web.controller;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import project.model.User;
import project.model.UserType;
import project.model.Video;
import project.service.UserService;
import project.service.VideoService;
import project.support.UserDTOtoUser;
import project.support.UserToUserDTO;
import project.support.VideoToVideoDTO;
import project.web.dto.UserDTO;
import project.web.dto.VideoDTO;

import javax.validation.Valid;
import java.util.Comparator;
import java.util.Date;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ApiUserController {

    private @NonNull UserService userService;
    private @NonNull UserToUserDTO userToUserDTO;
    private @NonNull UserDTOtoUser userDTOtoUser;
    private @NonNull VideoService videoService;
    private @NonNull VideoToVideoDTO videoToVideoDTO;

    @GetMapping
    public @ResponseBody
    Iterable<UserDTO> getUsers() {

        return userService.findAll()
                .stream().sorted(Comparator.comparing(User::getUserName))
                .map(userToUserDTO::convert)
                .collect(Collectors.toList());
    }

    @GetMapping("/{userId}/videos")
    public @ResponseBody
    Iterable<VideoDTO> getVideosByUserId(@PathVariable Long userId) {

        return videoService.findByUserId(userId)
                .stream().sorted(Comparator.comparing(Video::getViews))
                .map(videoToVideoDTO::convert)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public @ResponseBody
    UserDTO getUser(@PathVariable Long id) {

        return userService.findById(id)
                .map(userToUserDTO::convert)
                .orElseThrow(() -> new IllegalArgumentException("User with id" + id + "does not exist"));
    }

    @DeleteMapping("/{id}")
    public @ResponseBody
    UserDTO deleteUser(@PathVariable Long id) {

        return userService.deleteById(id)
                .map(userToUserDTO::convert)
                .orElseThrow(() -> new IllegalArgumentException("User with id" + id + "does not exist"));
    }

    @PostMapping
    public ResponseEntity<UserDTO> save(@RequestBody @Validated UserDTO userDTO){

        if(!userDTO.getPassword().equals(userDTO.getConfirmedPassword())){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        userDTO.setDate(new Date());
        userDTO.setUserType(UserType.REGULAR);
        userDTO.setBlocked(false);
        User user = userDTOtoUser.convert(userDTO);
        userService.save(user);

        return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
    }


}

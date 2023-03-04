package com.quizz.quizPortal.controller;

import com.quizz.quizPortal.entity.User;

import com.quizz.quizPortal.exception.UserNotFoundException;
import com.quizz.quizPortal.repository.UserRepository;
import com.quizz.quizPortal.service.UserService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserController {
    private final UserRepository userRepository;
    private final UserService userService;

    public UserController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    //Saving Useer in DB
    @PostMapping("/save")
    public User saveUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PostMapping("/role/addtouser")
    public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUserForm form){
        userService.addRoleToUser(form.getUsername(), form.getRolename());
        return ResponseEntity.ok().build();
    }


    @GetMapping("/list")
    List<User> all() {
        return userRepository.findAll();
    }

    @GetMapping("/{userName}")
    public User getUser(@PathVariable("userName") String username) {
        return this.userService.getUser(username);
    }


    @GetMapping("/users/{id}")
    User one(@PathVariable Long id) {

        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long id, @RequestBody User user) throws Exception {
       User newUser = userRepository.findById(id)
                .orElseThrow(() -> new Exception("User not exist with id: " + id));

        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setEmail(user.getEmail());
        userRepository.save(newUser);

        return ResponseEntity.ok(newUser);

    }

    @DeleteMapping("/users/{id}")
    void deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
    }
}

@Data
class RoleToUserForm{
    private String username;
    private String rolename;
}

package com.example.spring_crud.controller;

import com.example.spring_crud.entity.User;
import com.example.spring_crud.exception.UserNotFoundException;
import com.example.spring_crud.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User createUser(@RequestBody @Valid User user) {
        return userService.createUser(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) throws UserNotFoundException {
        return ResponseEntity.ok(userService.getUserById(id));
    }


    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable Long id) throws UserNotFoundException {
        User userToBeUpdated = userService.getUserById(id);

        if (userToBeUpdated == null) {
            return ResponseEntity.notFound().build();
        }
        userToBeUpdated.setEmail(user.getEmail());
        userToBeUpdated.setName(user.getName());
        User updatedUser = userService.updateUser(userToBeUpdated);
        return ResponseEntity.ok(userToBeUpdated);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUserById(@PathVariable Long id) throws UserNotFoundException {
        User user = userService.getUserById(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        userService.deleteUser(user);
        return ResponseEntity.ok().build();
    }
}

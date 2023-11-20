package com.example.spring_crud.service;

import com.example.spring_crud.entity.User;
import com.example.spring_crud.exception.UserNotFoundException;
import com.example.spring_crud.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public User createUser(User user) {
        return userRepo.save(user);
    }

    public User getUserById(Long id) throws UserNotFoundException {
        User user = userRepo.findById(id).orElse(null);
        if (user != null) {
            return user;
        } else {
            throw new UserNotFoundException("User not found with Id: "+id);
        }
    }

    public User updateUser(User userToBeUpdated) {
        return userRepo.save(userToBeUpdated);
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public void deleteUser(User user) {
        userRepo.delete(user);
    }
}

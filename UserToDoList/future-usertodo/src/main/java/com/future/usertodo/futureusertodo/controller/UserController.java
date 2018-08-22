package com.future.usertodo.futureusertodo.controller;

import com.future.usertodo.futureusertodo.exception.ResourceNotFoundException;
import com.future.usertodo.futureusertodo.model.User;
import com.future.usertodo.futureusertodo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public Page<User> getUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @PostMapping("/users")
    public User createUser(@Valid @RequestBody User user) {
        return userRepository.save(user);
    }

    @PutMapping("/users/{userId}")
    public User updateUser(@PathVariable Long userId,
                           @Valid @RequestBody User userRequest) {
        return userRepository.findById(userId)
                .map(user -> {
                    user.setUsername(userRequest.getUsername());
                    user.setName(userRequest.getName());
                    return userRepository.save(user);
                }).orElseThrow(()-> new ResourceNotFoundException("User ID" + userId + "cannot be found!"));
    }

    @DeleteMapping("/users/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Long userId) {
        return userRepository.findById(userId)
                .map(user -> {
                    userRepository.delete(user);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("User ID" + userId + "cannot be deleted!"));
    }
}

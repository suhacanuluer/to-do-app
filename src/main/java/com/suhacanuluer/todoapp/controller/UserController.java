package com.suhacanuluer.todoapp.controller;

import com.suhacanuluer.todoapp.entity.Users;
import com.suhacanuluer.todoapp.repository.TodoRepository;
import com.suhacanuluer.todoapp.repository.UserRepository;
import com.suhacanuluer.todoapp.request.AddUserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/{userId}")
    public Users getUserById(@PathVariable Long userId){
        return userRepository.findById(userId).orElseThrow(() -> new NoSuchElementException());
    }

    @PostMapping
    public Users addUser(@RequestBody AddUserRequest userRequest){
        Users users = new Users();
        users.setUsername(userRequest.getUsername());
        users.setPassword(userRequest.getPassword());
        return userRepository.save(users);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId){
        Users users = userRepository.findById(userId).orElseThrow(() -> new NoSuchElementException());
        userRepository.delete(users);
    }
}

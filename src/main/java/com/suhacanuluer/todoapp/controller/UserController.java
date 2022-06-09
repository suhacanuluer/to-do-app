package com.suhacanuluer.todoapp.controller;

import com.suhacanuluer.todoapp.entity.Users;
import com.suhacanuluer.todoapp.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ROLE_USER')")
    public List<Users> list() {
        return userService.list();
    }
}

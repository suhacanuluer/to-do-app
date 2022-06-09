package com.suhacanuluer.todoapp.service;

import com.suhacanuluer.todoapp.entity.Role;
import com.suhacanuluer.todoapp.entity.Users;

import java.util.List;

public interface UserService {
    Users save(Users user);
    Role save(Role role);
    void addRoleToUser(String username, String roleName);
    Users get(String username);
    List<Users> list();
}

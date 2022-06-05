package com.suhacanuluer.todoapp;

import com.suhacanuluer.todoapp.entity.Todo;
import com.suhacanuluer.todoapp.entity.Users;
import com.suhacanuluer.todoapp.repository.TodoRepository;
import com.suhacanuluer.todoapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ToDoAppApplication implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TodoRepository todoRepository;

    public static void main(String[] args) {
        SpringApplication.run(ToDoAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}

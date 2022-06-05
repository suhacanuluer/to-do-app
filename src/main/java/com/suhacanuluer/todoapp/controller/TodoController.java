package com.suhacanuluer.todoapp.controller;

import com.suhacanuluer.todoapp.entity.Todo;
import com.suhacanuluer.todoapp.entity.Users;
import com.suhacanuluer.todoapp.repository.TodoRepository;
import com.suhacanuluer.todoapp.repository.UserRepository;
import com.suhacanuluer.todoapp.request.AddTodoRequest;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/todos")
public class TodoController {
    private TodoRepository todoRepository;
    private UserRepository userRepository;

    public TodoController(TodoRepository todoRepository, UserRepository userRepository) {
        this.todoRepository = todoRepository;
        this.userRepository = userRepository;
    }

    @PostMapping("/{userId}/add")
    public void addTodo(@PathVariable Long userId, @RequestBody AddTodoRequest todoRequest){
        Users users = userRepository.findById(userId).orElseThrow(() -> new NoSuchElementException());
        Todo todo = new Todo();
        todo.setContent(todoRequest.getContent());
        users.getTodoList().add(todo);
        todoRepository.save(todo);
        userRepository.save(users);
    }

    @PostMapping("/{todoId}")
    public void updateTodoCompleted(@PathVariable Long todoId){
        Todo todo = todoRepository.findById(todoId).orElseThrow(() -> new NoSuchElementException());
        todo.setCompleted(!todo.getCompleted());
        todoRepository.save(todo);
    }

    @DeleteMapping("/{todoId}")
    public void deleteTodo(@PathVariable Long todoId){
        Todo todo = todoRepository.findById(todoId).orElseThrow(() -> new NoSuchElementException());
        todoRepository.delete(todo);
    }
}

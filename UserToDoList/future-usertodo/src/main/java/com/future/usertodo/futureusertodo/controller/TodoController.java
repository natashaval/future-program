package com.future.usertodo.futureusertodo.controller;

import com.future.usertodo.futureusertodo.exception.ResourceNotFoundException;
import com.future.usertodo.futureusertodo.model.Todo;
import com.future.usertodo.futureusertodo.repository.TodoRepository;
import com.future.usertodo.futureusertodo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class TodoController {
    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users/{userId}/todo")
    public List<Todo> getTodoByUserId(@PathVariable Long userId) {
        return todoRepository.findByUserId(userId);
    }

    @PostMapping("/users/{userId}/todo")
    public Todo addTodo(@PathVariable Long userId,
                        @Valid @RequestBody Todo todo) {
        return userRepository.findById(userId)
                .map(user -> {
                    todo.setUser(user);
                    return todoRepository.save(todo);
                }).orElseThrow(()->new ResourceNotFoundException("User ID" + userId + "not found, cannot add todo"));

    }

    @PutMapping("/users/{userId}/todos/{todoId}")
    public Todo updateTodo(@PathVariable Long userId, @PathVariable Long todoId,
                           @Valid @RequestBody Todo todoRequest){
        if (!userRepository.existsById(userId)) {
            throw new ResourceNotFoundException("User ID "+ userId + " not found!");
        }

        return todoRepository.findById(todoId)
                .map(todo -> {
                    todo.setTitle(todoRequest.getTitle());
                    todo.setDescription(todoRequest.getDescription());
                    return todoRepository.save(todo);
                }).orElseThrow(()-> new ResourceNotFoundException("Todo ID" + todoId + "not available"));
    }

    @DeleteMapping("/users/{userId}/todos/{todoId}")
    public ResponseEntity<?> deleteTodo(@PathVariable Long userId, @PathVariable Long todoId) {
        if (!userRepository.existsById(userId)) {
            throw new ResourceNotFoundException("User ID" + userId + "not found");
        }

        return todoRepository.findById(todoId)
                .map(todo -> {
                    todoRepository.delete(todo);
                    return ResponseEntity.ok().build();
                }).orElseThrow(()-> new ResourceNotFoundException(("Todo ID" + todoId + "not available")));
    }
}

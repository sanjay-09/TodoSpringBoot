package com.example.Todo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TodoController {
    private List<Todo> todos;

    TodoController(){
        todos=new ArrayList<>();
        todos.add(new Todo(true,1,"walk",1));
        todos.add(new Todo(false,2,"read",2));
    }

    @GetMapping("/todos")
    public ResponseEntity<List<Todo>> getTodos(){
        return ResponseEntity.ok(todos);
    }

    @PostMapping("/todo")
//    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Todo> createTodo(@RequestBody Todo newTodo){
        System.out.println(newTodo);
        todos.add(newTodo);
        return ResponseEntity.status(HttpStatus.CREATED).body(newTodo);
    }


}

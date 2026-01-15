package com.example.Todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/api/v1/todos")

public class TodoController {
    private List<Todo> todos;


    private TodoService todoService;

    TodoController(TodoService todoService){
        this.todoService=todoService;
        todos=new ArrayList<>();
        todos.add(new Todo(true,1,"walk",1));
        todos.add(new Todo(false,2,"read",2));

    }

    @GetMapping
    public ResponseEntity<List<Todo>> getTodos(@RequestParam(required = false,defaultValue = "true") Boolean isCompleted){
        System.out.println(isCompleted);
        System.out.println(this.todoService.play());
        if(isCompleted==null){
            return ResponseEntity.ok(todos);

        }
        return ResponseEntity.ok(todos);
    }

    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Todo> createTodo(@RequestBody Todo newTodo){
        System.out.println(newTodo);
        todos.add(newTodo);
        return ResponseEntity.status(HttpStatus.CREATED).body(newTodo);
    }


//    @GetMapping("/{todoId}")
//    public ResponseEntity<Todo> getTodoById(@PathVariable long todoId){
//        for(Todo t:todos){
//            if(t.getId()==todoId){
//                return ResponseEntity.ok(t);
//            }
//        }
//        return ResponseEntity.notFound().build(); //new ResponseEntity<Todo>(null, headers, HttpStatus.NOT_FOUND);
//
//    }

        @GetMapping("/{todoId}")
    public ResponseEntity<?> getTodoById(@PathVariable long todoId){
        for(Todo t:todos){
            if(t.getId()==todoId){
                return ResponseEntity.ok(t);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ErrorResponse("no todo found with todoID:"+todoId));
    }

    @DeleteMapping("/{todoId}")
    public ResponseEntity<?> deleteTodoById(@PathVariable long todoId){
        Iterator<Todo> iterator=todos.iterator();
        while(iterator.hasNext()){
            Todo t=iterator.next();
            if(t.getId()==todoId){
                iterator.remove();
                return ResponseEntity.status(HttpStatus.OK).body(t);
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(new ErrorResponse("todoId does not found"));
    }

    @PatchMapping("/{todoId}")
    public ResponseEntity<?> updateTodoById(@PathVariable long todoId,@RequestBody Todo updatedTodo){
        Todo t=null;
        for(Todo t1:todos){
            if(t1.getId()==todoId){
                t=t1;
            }
        }
        if(t==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("todoId does not found"));
        }
        if(updatedTodo.isCompleted()==true){
            t.setCompleted(true);
        }
        if(updatedTodo.getTitle()!=null){
            t.setTitle(updatedTodo.getTitle());

        }
        return  ResponseEntity.status(HttpStatus.OK).body(t);

    }







}

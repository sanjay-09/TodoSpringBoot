package com.example.Todo;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("AnotherTodoService")

public class AnotherTodoService implements TodoService{
    @Override
    public String play(){
        return "anotherTodoPlaying";
    }
}

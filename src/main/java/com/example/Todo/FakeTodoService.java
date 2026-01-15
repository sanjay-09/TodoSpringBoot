package com.example.Todo;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;



@Component("FakeTodoService")
@Primary
public class FakeTodoService implements TodoService {

    public String play(){
        return "fake playing";
    }
}


//Beans is the java object created/managed by Spring Container
//Dependency inversion:A class should depends upon the abstraction rather then concerte classes
//Dependency injection:A class should receives its dependencies from outside,rather then creating its own.
//In Java,Spring container creates a bean(java object) and attach it to the constructor where you can set it(@Autowire can do it automaticaly)
//A Spring can create and inject if the container has @Component to it
//if ther are multiple class implementing the interface:
//use:@Primary in one of the class
//@Qualifier("") for the same
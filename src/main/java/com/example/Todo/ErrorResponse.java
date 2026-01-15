package com.example.Todo;

public class ErrorResponse {
   String message;

    ErrorResponse(String message){
        this.message=message;
    }

    public String getMessage() { return message; }

}

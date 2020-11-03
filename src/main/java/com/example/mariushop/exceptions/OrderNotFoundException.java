package com.example.mariushop.exceptions;

public class OrderNotFoundException extends RuntimeException{
    public OrderNotFoundException(String message){
        super(message);
    }
}

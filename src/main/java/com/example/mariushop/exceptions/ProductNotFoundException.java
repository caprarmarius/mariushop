package com.example.mariushop.exceptions;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(String message)
    {
        super(message);
    }
}

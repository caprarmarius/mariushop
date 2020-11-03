package com.example.mariushop.controllers;

import com.example.mariushop.dtos.LogInDTO;
import com.example.mariushop.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/login")
public class LogInController {
    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LogInDTO logIn(@RequestBody LogInDTO logInDTO) {
        return userService.validateCredentials(logInDTO);
    }
}

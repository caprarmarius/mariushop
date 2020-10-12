package com.example.mariushop.controllers;

import com.example.mariushop.services.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class TestController {

    private  final TestService testService;

   @GetMapping
    public String testGet()
   {
      return testService.stringToBrowser();
   }
}

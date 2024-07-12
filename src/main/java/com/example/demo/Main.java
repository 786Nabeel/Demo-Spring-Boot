package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Main {

  @GetMapping("/hello")
  public String hello() {
    return "Hello, World!"; // Return a simple string
  }

  @GetMapping("/json")
  public MyObject[] getJson() {
    MyObject obj = new MyObject("John Doe", 30);

    return new MyObject[] { obj, obj, obj };
  }
}

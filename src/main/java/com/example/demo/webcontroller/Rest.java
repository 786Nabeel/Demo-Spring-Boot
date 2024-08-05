package com.example.demo.webcontroller;

import com.example.demo.entities.MyObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.data.Names;

@RestController
public class Rest {

  @GetMapping("/hello")
  public String hello() {
    return "Hello, World!"; // Return a simple string
  }

  @GetMapping("/json")
  public MyObject[] getJson() {
    MyObject obj = new MyObject("John Doe", 30);

    return new MyObject[] { obj, obj, obj };
  }

  @GetMapping("/getSection/{id}")
  public String getSection(@PathVariable String id) {
    try {
      String section = Names.getSection(id);
      if (section == null)
        return String.format("Hi %s your section is not found ", id);
      return String.format("Hi %s your section is ", id) + Names.getSection(id);
    } catch (Exception e) {
      return e.getLocalizedMessage();
    }
  }

  @GetMapping("fileNames/{name}")

  public String getSectionByName(@PathVariable String name) {
    try {
      String section = Names.getSectionFromFile(name);
      if (section == null)
        return String.format("Hi %s your section is not found ", name);
      return String.format("Hi %s your section is ", name) + Names.getSection(name);
    } catch (Exception e) {
      return e.getLocalizedMessage();
    }
  }
}

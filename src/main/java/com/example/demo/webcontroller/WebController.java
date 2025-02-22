package com.example.demo.webcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/file")
    public String index() {
        return "index";
    }
    @GetMapping("/file2")
    public String index2() {
        return "main";
    }

    @GetMapping("/counterApp") // this is the mapping of the URL
    public String counterApp() {
        return "counterApp";
    }
    
    @GetMapping("/color")
    public String color(){
        return "color";
    }

    @GetMapping("/studentForm")
    public String studentForm(){
        return "studentForm";
    }

    @GetMapping("/studentData")
    public String studentData(){
        return "studentData";
    }
}

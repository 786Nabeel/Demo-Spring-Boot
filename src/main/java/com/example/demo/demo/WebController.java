package com.example.demo.demo;

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
}

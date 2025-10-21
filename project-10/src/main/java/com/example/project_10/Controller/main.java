package com.example.project_10.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
@Controller
public class main {

    @GetMapping("/home")
    public String home() {
        return "home";
        
    }
    @GetMapping("/book")
    public String book() {
        return "book";
        
    }
    @GetMapping("/partials")
    public String navigation() {
        return "index";
    }

}
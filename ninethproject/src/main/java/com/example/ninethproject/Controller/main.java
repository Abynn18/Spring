package com.example.ninethproject.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
@Controller
public class main {

    @GetMapping("/home")
    public String home() {
        return "home";
        
    }
    @GetMapping("/product")
    public String product() {
        return "product";
        
    }
    @GetMapping("/partials")
    public String navigation() {
        return "index";
    }

}
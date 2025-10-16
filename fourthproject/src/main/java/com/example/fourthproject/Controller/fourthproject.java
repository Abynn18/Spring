package com.example.fourthproject.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class fourthproject {

   
    @GetMapping("/start")
    public String redirectToWelcome() {
        return "redirect:/welcome";
    }

    
    @GetMapping("/welcome")
    public String welcomePage() {
        return "welcome";
    }
}
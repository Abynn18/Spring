package com.example.sixthproject.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
@Controller
public class sixthproject {

    @GetMapping("/home")
    public String home() {
        return "redirect:/hello";
    }

    @GetMapping("/hello")
    public String hello(Model model) {
        String message = "KGF 2";
        model.addAttribute("message", message);
        String hello = "<h4>K.G.F: Chapter 2: Directed by Prashanth Neel. With Yash, Sanjay Dutt, Raveena Tandon, Srinidhi Shetty.</h4>";
        model.addAttribute("hello", hello);
        boolean isLoggedIn = true;
        model.addAttribute("isLoggedIn", isLoggedIn);
        return "hello";
    }
}
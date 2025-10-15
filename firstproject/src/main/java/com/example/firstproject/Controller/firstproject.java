package com.example.firstproject.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
@Controller
public class firstproject {

    @GetMapping("/first")
    public String first() {
        return "first";
    }
}
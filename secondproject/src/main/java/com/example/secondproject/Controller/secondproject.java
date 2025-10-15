package com.example.secondproject.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
@Controller
public class secondproject {

    @GetMapping("/second")
    public String second() {
        return "second";
    }
}
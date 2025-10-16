package com.example.thirdproject.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class thirdproject {

    
    @GetMapping("/start")
    public String redirectToPortfolio() {
        return "redirect:/portfolio";
    }

  
    @GetMapping("/portfolio")
    public String showPortfolio() {
        return "portfolio";
    }
}
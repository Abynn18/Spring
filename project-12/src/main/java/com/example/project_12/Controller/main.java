package com.example.project_12.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;
import com.example.project_12.userdetails;

@Controller
public class main {

    @GetMapping("/form")
    public String processForm(Model model) {
        userdetails userDetails = new userdetails();
        model.addAttribute("userdetails", userDetails);
        return "userdetails";
    }

    @PostMapping("/submit")
    public String submitForm(@Valid @ModelAttribute("userdetails") userdetails userDetails, BindingResult result, Model model) {
        model.addAttribute("userdetails", userDetails);
        if (result.hasErrors()) {
            return "userdetails";
        } else {
            return "success";
        }
    }
}

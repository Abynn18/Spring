package com.example.seventhproject.controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.seventhproject.Models.product;
import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
@Controller
public class grocery {

	@GetMapping("/product")
    public String getProduct(Model model) {
		product product = new product(101,"sugar",(float) 55.5);
        model.addAttribute("product", product);
        return "product";
    }

    @GetMapping("/products")
    public String getProducts(Model model) {
        List<product> products = new ArrayList<>();
        products.add(new product(101, "sugar",(float) 55.5));
        products.add(new product(102, "salt",(float) 20.0));
        products.add(new product(103, "wheat flour",(float) 38.75));
        model.addAttribute("products", products);
        return "products";
    }
}
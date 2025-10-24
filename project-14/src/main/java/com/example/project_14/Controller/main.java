package com.example.project_14.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.project_14.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.example.project_14.models.Productmodel; 
@Controller
public class main {

	@GetMapping("/product")
	public String Product(Model model) {
	    model.addAttribute("message", "Enter Your product Details");
	    return "product";
	}
	
	@GetMapping("/products")
	public String showProducts(Model model) {
		 Iterable<Productmodel> productList = productRepository.findAll();
	    model.addAttribute("products", productList);
	    return "products";
	}

	@Autowired
	private ProductRepository productRepository;
	@PostMapping("/save-product")
	public String Product(Productmodel productData,Model model) {
	    
	    Productmodel n = new Productmodel();
	    n.setName(productData.getName());
	    n.setDescription(productData.getDescription());    
	    n.setPrice(productData.getPrice()); 
	    productRepository.save(n);
	    
	    model.addAttribute("message", "The product " + productData.getName() +" is saved successfully");
	    return "product"; 
	} 

}
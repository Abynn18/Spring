package com.example.project_13.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.project_13.Repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.example.project_13.models.Bookmodel; 
@Controller
public class main {

	@GetMapping("/book")
	public String Product(Model model) {
	    model.addAttribute("message", "Enter Your product Details");
	    return "Book";
	}
	@Autowired
	private Repository productRepository;
	@PostMapping("/save-product")
	public String Product(Bookmodel productData, Model model) {
	    Bookmodel n = new Bookmodel();
	    n.setBook(productData.getBook());
	    n.setAuthor(productData.getAuthor());
	    n.setPrice(productData.getPrice());
	    productRepository.save(n);

	    model.addAttribute("message", "The product " + productData.getBook() + " is saved successfully");
	    return "Book"; 
	}

	@GetMapping("/products")
	public String showProducts(Model model) {
		 Iterable<Bookmodel> productList = productRepository.findAll();
	    model.addAttribute("products", productList);
	    return "products";
	}


}

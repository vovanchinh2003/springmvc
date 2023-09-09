package pxu.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pxu.com.model.Product;
import pxu.com.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	public ProductService productService;

//	@RequestMapping(value = "/add", method = RequestMethod.GET)
	@RequestMapping("/add")
	public String processAddProductForm(@ModelAttribute("product") Product product) {
		return "/home";
	}

	@GetMapping("/products")
	public String list(Model model) {
		List<Product> products = this.productService.fimAll();
		model.addAttribute("products", products);
		return "list";
	}

	@PostMapping("/save")
	public String saveProduct(@ModelAttribute("product") Product product) {
		int romdomid = (int) (Math.random() * 1000);
		product.setCode(romdomid);
		this.productService.save(product);
		return "redirect:/products";
	}

	@GetMapping(value = "/update")
	public String update(@RequestParam("code") Integer productid, Model model) {
		Product product = this.productService.finByid(productid);
		model.addAttribute("product", product);
		return "update";

	}

	@GetMapping(value = "/view")
	public String view(@RequestParam("code") Integer productid, Model model) {
		Product product = this.productService.finByid(productid);
		model.addAttribute("product", product);
		return "details";

	}

	@PostMapping("/edit")
	public String updateProduct(@ModelAttribute("product") Product product) {
		this.productService.update(product);
		return "redirect:/products";
	}

	@GetMapping("/delete")
	public String deleteProduct(@RequestParam("code") Integer productId) {
		this.productService.delete(productId);
		return "redirect:/products";
	}
}

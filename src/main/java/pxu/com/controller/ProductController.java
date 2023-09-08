package pxu.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pxu.com.model.Product;
import pxu.com.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	public ProductService productService;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String processAddProductForm(@ModelAttribute("product") Product product) {
		return "/home";
	}

	@GetMapping("/products")
	public ModelAndView list() {
		List<Product> products = this.productService.fimAll();
		ModelAndView modelAndView = new ModelAndView("/list");
		modelAndView.addObject("products", products);
		return modelAndView;
	}

	@GetMapping("/new")
	public ModelAndView showCreateform() {
		ModelAndView modelAndView = new ModelAndView("/list");
		modelAndView.addObject("product", new Product());
		return modelAndView;
	}

	@PostMapping("/new")
	public String createProduct(@ModelAttribute("product") Product product) {
		int romdomid = (int) (Math.random() * 1000);
		product.setCode(romdomid);
		this.productService.save(product);
		return "redirect:/products";
	}

	@GetMapping(value = "/update")
	public ModelAndView update(@RequestParam("code") Integer productid) {
		Product product = this.productService.finByid(productid);
		ModelAndView modelAndView = new ModelAndView("/update");
		modelAndView.addObject("product", product);
		return modelAndView;

	}

	@GetMapping(value = "/view")
	public ModelAndView view(@RequestParam("code") Integer productid) {
		Product product = this.productService.finByid(productid);
		ModelAndView modelAndView = new ModelAndView("/details");
		modelAndView.addObject("product", product);
		return modelAndView;

	}

	@GetMapping("/edit")
	public ModelAndView showEditForm(@RequestParam("code") Integer productId) {
		Product product = this.productService.finByid(productId);
		ModelAndView modelAndView = new ModelAndView("/edit");
		modelAndView.addObject("product", product);
		return modelAndView;
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

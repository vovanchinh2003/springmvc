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

	@RequestMapping(value = "product/add", method = RequestMethod.GET)
	public String processAddProductForm(@ModelAttribute("product") Product product) {
		return "product/home";
	}

	@GetMapping("/products")
	public ModelAndView list() {
		List<Product> products = this.productService.fimAll();
		ModelAndView modelAndView = new ModelAndView("product/list");
		modelAndView.addObject("products", products);
		return modelAndView;
	}

	@GetMapping("/new")
	public ModelAndView showCreateform() {
		ModelAndView modelAndView = new ModelAndView("product/create");
		modelAndView.addObject("product", new Product());
		return modelAndView;
	}

	@PostMapping("/new")
	public ModelAndView createProduct(@ModelAttribute("product") Product product) {
		int romdomid = (int) (Math.random() * 1000);
		product.setCode(romdomid);
		this.productService.save(product);

		ModelAndView modelAndView = new ModelAndView("product/create");
		modelAndView.addObject("product", new Product());
		modelAndView.addObject("mess", "new product wwas created");

		return modelAndView;
	}

	@GetMapping(value = "/view")
	public ModelAndView view(@RequestParam("id") Integer productid) {
		Product product = this.productService.finByid(productid);
		ModelAndView modelAndView = new ModelAndView("product/view");
		modelAndView.addObject("product", product);
		return modelAndView;

	}
}

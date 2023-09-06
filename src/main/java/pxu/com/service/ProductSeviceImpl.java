package pxu.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import pxu.com.model.Product;

public class ProductSeviceImpl implements ProductService {

	@Autowired
	public ProductService productService;

	@Override
	public List<Product> fimAll() {
		// TODO Auto-generated method stub
		return this.productService.fimAll();
	}

	@Override
	public Product finByid(int id) {
		// TODO Auto-generated method stub
		return this.productService.finByid(id);
	}

	@Override
	public void save(Product product) {
		// TODO Auto-generated method stub
		this.productService.save(product);
	}

}

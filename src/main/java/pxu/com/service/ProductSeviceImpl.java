package pxu.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import pxu.com.model.Product;
import pxu.com.repository.ProductRepository;

public class ProductSeviceImpl implements ProductService {

	@Autowired
	public ProductRepository productRepository;

	@Override
	public List<Product> fimAll() {
		// TODO Auto-generated method stub
		return this.productRepository.fimAll();
	}

	@Override
	public Product finByid(int code) {
		// TODO Auto-generated method stub
		return this.productRepository.finByid(code);
	}

	@Override
	public void save(Product product) {
		// TODO Auto-generated method stub
		this.productRepository.save(product);
	}

	@Override
	public void update(Product product) {
		this.productRepository.save(product);
	}

	@Override
	public void delete(int code) {
		this.productRepository.delete(code);
	}

}

package pxu.com.service;

import java.util.List;

import org.springframework.stereotype.Component;

import pxu.com.model.Product;

public interface ProductService {
	List<Product> fimAll();
	Product finByid(int id);
	void save(Product product);
}

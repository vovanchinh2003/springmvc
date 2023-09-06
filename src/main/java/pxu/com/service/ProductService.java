package pxu.com.service;

import java.util.List;

import org.springframework.stereotype.Service;

import pxu.com.model.Product;

@Service
public interface ProductService {
	List<Product> fimAll();
	Product finByid(int id);
	void save(Product product);
}

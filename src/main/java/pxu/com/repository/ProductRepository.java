package pxu.com.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import pxu.com.model.Product;

public interface ProductRepository {
	List<Product> fimAll();

	Product finByid(int code);

	void save(Product product);
	void update(Product product); 

	void delete(int code);
}

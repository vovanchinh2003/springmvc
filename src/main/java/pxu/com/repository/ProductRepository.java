package pxu.com.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import pxu.com.model.Product;

public interface ProductRepository {
	List<Product> fimAll();

	Product finByid(int id);

	void save(Product product);
}

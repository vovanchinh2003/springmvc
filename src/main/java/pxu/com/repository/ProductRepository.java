package pxu.com.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import pxu.com.model.Product;

@Repository
public interface ProductRepository {
	List<Product> fimAll();

	Product finByid(int id);

	void save(Product product);
}

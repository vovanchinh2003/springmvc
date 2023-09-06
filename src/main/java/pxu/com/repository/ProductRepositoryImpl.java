package pxu.com.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pxu.com.model.Product;

public class ProductRepositoryImpl implements ProductRepository {

	private static final Map<Integer, Product> products;

	static {
		products = new HashMap<Integer, Product>();
		products.put(1, new Product(1, "Iphone1", 101));
		products.put(2, new Product(1, "Iphone2", 102));
		products.put(3, new Product(1, "Iphone3", 103));
		products.put(4, new Product(1, "Iphone4", 104));
		products.put(5, new Product(1, "Iphone5", 105));
		products.put(6, new Product(1, "Iphone6", 106));
	}

	@Override
	public List<Product> fimAll() {
		// TODO Auto-generated method stub
		return new ArrayList<Product>(products.values());
	}

	@Override
	public Product finByid(int id) {
		// TODO Auto-generated method stub
		Product product = products.get(id);
		return product;
	}

	@Override
	public void save(Product product) {
		// TODO Auto-generated method stub
		products.put(product.getCode(), product);
	}

}

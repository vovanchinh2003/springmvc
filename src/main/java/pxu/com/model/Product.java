package pxu.com.model;

public class Product {
	private int code;
	private String name;
	private float price;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Product(int i, String name, float price) {
		super();
		this.code = i;
		this.name = name;
		this.price = price;
	}
	public Product() {
		super();
	}
	
	
	
}

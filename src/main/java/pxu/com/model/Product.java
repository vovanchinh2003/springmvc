package pxu.com.model;

public class Product {
	private int code;
	private String name;
	private float price;
	private String image;

	public Product(int code, String name, float price, String image) {
		super();
		this.code = code;
		this.name = name;
		this.price = price;
		this.image = image;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

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
	public Product() {
		super();
	}

}

package group.faf.bookstore.model.order;

import group.faf.bookstore.model.customer.Customer;
import group.faf.bookstore.model.product.Product;
import group.faf.bookstore.model.product.book.Book;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class Cart {
	private int id;
	private Map<Product, Integer> products;
	private float totalPrice;
	public Cart(int id, List<Product> product, float totalPrice ) {
		this.id = id;
		this.products = products;
		this.totalPrice = totalPrice;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setProducts(Map<Product, Integer> products) {
		this.products = products;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Map<Product, Integer> getProducts() {
		return products;
	}

	public float getTotalPrice() {
		float total=0;
		for (Map.Entry<Product, Integer> productIntegerEntry : products.entrySet()) {
			total+=productIntegerEntry.getKey().getPrice()*productIntegerEntry.getValue();

		}
		this.totalPrice = total;
		return totalPrice;
	}
	public void add(Product product, int quantity){
		this.products.put(product,quantity);
	}

}
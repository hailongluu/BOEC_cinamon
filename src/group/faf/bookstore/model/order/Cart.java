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
	private int customerId;
	private String customerName;
	public Cart(int id, Map<Product, Integer> products , Customer customer) {
		this.id = id;
		this.products = products;
		this.totalPrice = getTotalPrice();
		this.customerId = customer.getId();
		this.customerName = customer.getFullName().getFullName();
	}

	public Cart(Map<Product, Integer> products) {
		this.products = products;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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
		for (Product product : products.keySet()) {
			total+=product.getPrice() * products.get(product);
		}
		this.totalPrice = total;
		return totalPrice;
	}
	public void add(Product product, int quantity){
		this.products.put(product, quantity);
	}

}
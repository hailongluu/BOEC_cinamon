package group.faf.bookstore.model.order;

import group.faf.bookstore.model.customer.Customer;
import group.faf.bookstore.model.product.Product;
import group.faf.bookstore.model.product.book.Book;

import java.util.Date;
import java.util.List;

public class Cart {
	private int id;
	private List<Product> products;
	private float totalPrice;
	private int customerId;
	private String customerName;
	public Cart(int id, List<Product> product, float totalPrice , Customer customer) {
		this.id = id;
		this.products = products;
		this.totalPrice = totalPrice;
		this.customerId = customer.getId();
		this.customerName = customer.getFullName().getFullName();
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

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<Product> getProducts() {
		return products;
	}

	public float getTotalPrice() {
		float total=0;
		for (Product product : products) {
			total+=product.getPrice();
		}
		this.totalPrice = total;
		return totalPrice;
	}
	public void add(Product product){
		this.products.add(product);
	}

}
package group.faf.bookstore.model.order;

import group.faf.bookstore.model.product.Product;
import group.faf.bookstore.model.staff.Seller;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class Bill {
	private int id;
	Map<String, Float> listItems;
	private double totalPrice;
	private Date dateCreated;
	private boolean status;
	public Seller seller;

}
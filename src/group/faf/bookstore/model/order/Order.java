package group.faf.bookstore.model.order;

import group.faf.bookstore.model.customer.Customer;
import group.faf.bookstore.model.order.state.*;

import java.util.Date;

public class Order {

	private int id;
	OrderState currentState;
	DeliveryState currentDeliveryState;
	private Date createTime;
	private Cart cart;
	private String shippingAddress;
	private PaymentMethod paymentMethod;
	private int idCustomer;
	private String customerName;

	public Order() {
		this.currentDeliveryState = Packaged.getInstance();
		this.currentState = Confirmed.getInstance();
	}

	public Order(int id, OrderState currentState, DeliveryState currentDeliveryState, Date createTime, Cart cart, String shippingAddress, PaymentMethod paymentMethod) {
		this.id = id;
		this.currentState = currentState;
		this.currentDeliveryState = currentDeliveryState;
		this.createTime = createTime;
		this.cart = cart;
		this.shippingAddress = shippingAddress;
		this.paymentMethod = paymentMethod;
		this.idCustomer = cart.getCustomerId();
		this.customerName = cart.getCustomerName();
	}

	public Order(int id, Date createTime, Cart cart, String shippingAddress, PaymentMethod paymentMethod) {
		this.currentDeliveryState = Packaged.getInstance();
		this.currentState = Confirmed.getInstance();
		this.id = id;
		this.createTime = createTime;
		this.cart = cart;
		this.shippingAddress = shippingAddress;
		this.paymentMethod = paymentMethod;
		this.idCustomer = cart.getCustomerId();
		this.customerName = cart.getCustomerName();
	}

	public DeliveryState getCurrentDeliveryState() {
		return currentDeliveryState;
	}

	public void setCurrentDeliveryState(DeliveryState currentDeliveryState) {
		this.currentDeliveryState = currentDeliveryState;
	}

	public OrderState getCurrentState() {
		return currentState;
	}

	public void setcurrentState(OrderState orderState) {
		this.currentState = orderState;
	}

	public void update(){
		this.currentState.updateState(this);
	}

	public void updateDeliveryState(){
		this.currentDeliveryState.updateState(this);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public int getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(int idCustomer) {
		this.idCustomer = idCustomer;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
}
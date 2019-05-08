package group.faf.bookstore.model.order;

import java.util.Date;

public class CreditCardPayment {
	private int id;
	private String cardNo;
	private String ownerName;
	private Date exp;
	private String pin;

	public CreditCardPayment(int id, int discriminator) {

	}
}
package group.faf.bookstore.model.order;
public class BankPayment {
	private int id;
	private Bank bank;
	private String ownerName;
	private String cardNo;
	private String duration;

	public BankPayment(int id, int discriminator) {

	}
}
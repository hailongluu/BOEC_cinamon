package group.faf.bookstore.model.customer;


public class Customer {
	private int id;
	private int age;
	private String phone;
	private Account account;
	public FullName fullName;
	public Address address;

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public FullName getFullName() {
		return fullName;
	}

	public void setFullName(FullName fullName) {
		this.fullName = fullName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Customer(Account account, FullName fullName, Address address, int id, int age, String phone) {
		this.id = id;
		this.age = age;
		this.phone = phone;
		this.account = account;
		this.fullName = fullName;
		this.address = address;
	}

	public Customer(Account account, FullName fullName, Address address, int id) {
		this.account = account;
		this.fullName = fullName;
		this.address = address;
		this.id = id;
	}

	public int getId() {
		return id;
	}



	@Override
	public String toString() {
		return "Customer{" +
				"id=" + id +
				", fullName=" + fullName +
				", address=" + address +
				'}';
	}
	public static class CustomerBuilder{
		private final String username;
		private final String pass;
		private final String firstName;
		private final String lastName;
		private int age;
		private String address;
		private String phone;

		public CustomerBuilder(String username, String pass, String firstName, String lastName) {
			this.username = username;
			this.pass = pass;
			this.firstName = firstName;
			this.lastName = lastName;
		}

		public CustomerBuilder age(int age){
			this.age = age;
			return this;
		}
		public  CustomerBuilder address(String add){
			this.address = add;
			return this;
		}
		public CustomerBuilder phone(String phone){
			this.phone = phone;
			return this;
		}
		public Customer build(){
			FullName fullName = new FullName(this.firstName,"", this.lastName);
			Account account = new Account(this.username, this.pass);
			Address address = new Address(this.address);
			Customer customer = new Customer(account,fullName,address,123,this.age,this.phone);
			return customer;
		}
	}
}
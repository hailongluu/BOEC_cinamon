package group.faf.bookstore.model.customer;

public class Address {
	private int id;
	private String street;
	private String number;
	public String country;
	public String city;
	public String district;
	public String ward;

	public Address(String street) {
		this.street = street;
	}

	public Address(int id, String street, String number, String country, String city, String district, String ward) {
		this.id = id;
		this.street = street;
		this.number = number;
		this.country = country;
		this.city = city;
		this.district = district;
		this.ward = ward;
	}

	public int getId() {
		return id;
	}

	public String getStreet() {
		return street;
	}

	public String getNumber() {
		return number;
	}

	public String getCountry() {
		return country;
	}

	public String getCity() {
		return city;
	}

	public String getDistrict() {
		return district;
	}

	public String getWard() {
		return ward;
	}

	@Override
	public String toString() {
		return "Address{" +
				"id=" + id +
				", street='" + street + '\'' +
				", number='" + number + '\'' +
				", country=" + country +
				", city=" + city +
				", district=" + district +
				", ward=" + ward +
				'}';
	}
}
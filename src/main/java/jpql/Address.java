package jpql;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {

	private String city;
	private String street;

	@Column(name = "ZIPCODE")
	private String zipcode;

	public Address() {
	}

	public Address(String city, String street, String zipcode) {
		this.city = city;
		this.street = street;
		this.zipcode = zipcode;
	}

	public String getCity() {
		return city;
	}

	public String getStreet() {
		return street;
	}

	public String getZipcode() {
		return zipcode;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Address address = (Address)o;
		return Objects.equals(getCity(), address.getCity()) && Objects.equals(getStreet(),
			address.getStreet()) && Objects.equals(getZipcode(), address.getZipcode());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getCity(), getStreet(), getZipcode());
	}
}

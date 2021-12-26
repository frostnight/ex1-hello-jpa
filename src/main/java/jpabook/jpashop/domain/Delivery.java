package jpabook.jpashop.domain;

import static javax.persistence.FetchType.*;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Delivery extends BaseEntity{

	@Id @GeneratedValue
	private Long id;

	@Embedded
	private Address address;

	private DeliveryStatus status;

	@OneToOne(mappedBy = "delivery", fetch = LAZY)
	private Order order;

	public Long getId() {
		return id;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public DeliveryStatus getStatus() {
		return status;
	}

	public void setStatus(DeliveryStatus status) {
		this.status = status;
	}
}

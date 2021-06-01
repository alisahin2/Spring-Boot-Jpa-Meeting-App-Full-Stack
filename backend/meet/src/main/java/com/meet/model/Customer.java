package com.meet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "customer" )
public class Customer {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private long id;
	
	@Column( name = "company_name" )
	private String companyName;
	
	@Column( name = "address" )
	private String address;
	
	@Column( name = "phone_number" )
	private String phoneNumber;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
	public Customer() {
	}
	
	public Customer(long id, String companyName, String address, String phoneNumber) {
		super();
		this.id = id;
		this.companyName = companyName;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", companyName=" + companyName + ", address=" + address + ", phoneNumber="
				+ phoneNumber + "]";
	}

}

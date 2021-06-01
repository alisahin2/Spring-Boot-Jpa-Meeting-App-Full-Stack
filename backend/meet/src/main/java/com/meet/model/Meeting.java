package com.meet.model;

import java.util.*;
import javax.persistence.*;

@Entity
@Table( name = "meeting" )
public class Meeting {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private long id;
	
	@Column( name = "title" )
	private String title;
	
	@Column( name = "description" )
	private String description;
	
	@Temporal(TemporalType.TIMESTAMP )
	private Date date;
	
	@OneToOne( cascade = CascadeType.ALL )
	private Employee employee;
	
	@OneToOne( cascade = CascadeType.ALL )
	private Customer customer;

	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Meeting() {
		super();
		
	}
	public Meeting(long id, String title, String description, Date date, Employee employee, Customer customer) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.date = date;
		this.employee = employee;
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Meeting [id=" + id + ", title=" + title + ", description=" + description + ", date=" + date
				+ ", employee=" + employee + ", customer=" + customer + "]";
	}

}

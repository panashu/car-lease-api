package com.ashupan.customerinfoservice.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
@ApiModel(value = "This is the Customer entity class")
public class Customer {
    
	@ApiModelProperty(value = "This is the id of customer")
    private long id;	
	
	@ApiModelProperty(value = "This is the name of customer")
	private String name;
	
	@ApiModelProperty(value = "This is the street of customer address")
    private String street;
	
	@ApiModelProperty(value = "This is the house number of customer address")
    private int houseNumber;
	
	@ApiModelProperty(value = "This is the zip code of customer address")
    private String zipCode;
	
	@ApiModelProperty(value = "This is the place/city of customer address")
    private String place;
	
	@ApiModelProperty(value = "This is the email address of customer address")
    private String emailAddress;
	
	@ApiModelProperty(value = "This is the phone number of customer")
    private String phoneNumber;

    public Customer(long id,String name, String street, int houseNumber, String zipCode,
    		String place, String emailAddress, String phoneNumber) {
    	this.id = id;
    	this.name = name;
        this.street = street;
        this.houseNumber = houseNumber;
        this.zipCode = zipCode;
        this.place = place;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
    }
    
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "name", nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "street", nullable = false)
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	@Column(name = "houseNumber", nullable = false)
	public int getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(int houseNumber) {
		this.houseNumber = houseNumber;
	}

	@Column(name = "zipCode", nullable = false)
	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	@Column(name = "place", nullable = false)
	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	@Column(name = "emailAddress", nullable = false)
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	@Column(name = "phoneNumber", nullable = false)
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", street=" + street + ", houseNumber=" + houseNumber 
				+ ", zipCode=" + zipCode + ", place=" + place + ", emailAddress=" + emailAddress
				+ ", phoneNumber=" + phoneNumber  
				+ "]";
	}
    
}

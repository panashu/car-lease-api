package com.ashupan.cardataservice.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "car")
@ApiModel(value = "This is the Car entity class")
public class Car {

	@ApiModelProperty(value = "This is the id of car")
	private long id;
	
	@ApiModelProperty(value = "This is the make of car")
    private String make;
	
	@ApiModelProperty(value = "This is the model of car")
    private String model;
	
	@ApiModelProperty(value = "This is the version of car")
    private String version;
	
	@ApiModelProperty(value = "This is the number of doors of car")
    private int numberOfDoors;
	
	@ApiModelProperty(value = "This is the co2 emission of car")
    private double emmissionCO2;
	
	@ApiModelProperty(value = "This is the gross price of car")
    private double grossPrice;
	
	@ApiModelProperty(value = "This is the net price of car")
    private double netPrice;
    
    public Car(){
    	
    }

    public Car(long id, String make, String model, String version, int numberOfDoors,
    		double emmissionCO2, double grossPrice, double netPrice) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.version = version;
        this.numberOfDoors = numberOfDoors;
        this.emmissionCO2 = emmissionCO2;
        this.grossPrice = grossPrice;
        this.netPrice = netPrice;
    }

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "make", nullable = false)
	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	@Column(name = "model", nullable = false)
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Column(name = "version", nullable = false)
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	@Column(name = "numberOfDoors", nullable = false)
	public int getNumberOfDoors() {
		return numberOfDoors;
	}

	public void setNumberOfDoors(int numberOfDoors) {
		this.numberOfDoors = numberOfDoors;
	}

	@Column(name = "emmissionCO2", nullable = false)
	public double getEmmissionCO2() {
		return emmissionCO2;
	}

	public void setEmmissionCO2(double emmissionCO2) {
		this.emmissionCO2 = emmissionCO2;
	}

	@Column(name = "grossPrice", nullable = false)
	public double getGrossPrice() {
		return grossPrice;
	}

	public void setGrossPrice(double grossPrice) {
		this.grossPrice = grossPrice;
	}

	@Column(name = "netPrice", nullable = false)
	public double getNetPrice() {
		return netPrice;
	}

	public void setNetPrice(double netPrice) {
		this.netPrice = netPrice;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", make=" + make + ", model=" + model + ", version=" + version 
				+ ", numberOfDoors=" + numberOfDoors + ", emmissionCO2=" + emmissionCO2 + ", grossPrice=" + grossPrice 
				+ ", netPrice=" + netPrice 
				+ "]";
	}
}

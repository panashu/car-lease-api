package com.ashupan.leaserateservice.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Min;

@ApiModel(value = "This is the Lease Rate request class")
public class Lease {

	@Min(1)
	@ApiModelProperty(value = "This is the amount of kilometers on annual base")
	private long mileage;
    
	@Min(1)
	@ApiModelProperty(value = "This is the number of months in the contract")
	private int duration;
    
	@ApiModelProperty(value = "This is the interest rate fed as user input")
	private double interestRate;
	
	@ApiModelProperty(value = "This is the net price fed as user input")
    private double netPrice;
    
    
    public Lease(){
    	
    }

    public Lease(long mileage, int duration, double interestRate, double netPrice) {
        this.mileage = mileage;
        this.duration = duration;
        this.interestRate = interestRate;
        this.netPrice = netPrice;
    }

	public long getMileage() {
		return mileage;
	}

	public int getDuration() {
		return duration;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public double getNetPrice() {
		return netPrice;
	}

	public void setMileage(long mileage) {
		this.mileage = mileage;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public void setNetPrice(double netPrice) {
		this.netPrice = netPrice;
	}

    
}

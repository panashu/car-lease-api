package com.ashupan.leaserateservice.service;

import java.text.NumberFormat;
import java.util.Locale;

import org.springframework.stereotype.Service;

import com.ashupan.leaserateservice.model.Lease;

@Service
public class LeaseRateService {

	public String calculateLeaseRate(Lease lease) {
		double leaseRate = ((( lease.getMileage() / 12 ) * lease.getDuration() ) / lease.getNetPrice()) 
				+ ((( lease.getInterestRate() / 100 ) * lease.getNetPrice()) / 12 );
		NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.GERMANY);
		return formatter.format(leaseRate);
	}

}

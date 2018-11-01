package com.nagarro.java.training.flightSearch.modifyFare.impl;

import org.springframework.stereotype.Component;

import com.nagarro.java.training.flightSearch.modifyFare.ModifyFare;

@Component
public class MoifyFareImpl implements ModifyFare {

	@Override
	public int modifyFare(int currentFare) {

		int newFare = currentFare + ((currentFare * 40) / 100);
		
		return newFare;
	}

}

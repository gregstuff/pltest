package com.example.restapp.model;

import javax.validation.constraints.Pattern;

public class Postcode {

	@Pattern(regexp = "^[0-9]{4}$", message = "A post code must be 4 digits")
	private String postcodeNumber;

	public Postcode(String postcodeNumber) {
		this.postcodeNumber = postcodeNumber;
	}

	public String getPostcodeNumber() {
		return this.postcodeNumber;
	}

	public void setPostcodeNumber(String postcodeNumber) {
		this.postcodeNumber = postcodeNumber;
	}

}

package com.example.restapp.model;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import com.example.restapp.entity.PersonEntity;

public class Person {

	@NotBlank(message = "Name is mandatory")
	private String name;

	@Valid
	private Postcode postcode;

	public Person(String name, String postcode) {
		this.name = name;
		this.postcode = new Postcode(postcode);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Postcode getPostcode() {
		return postcode;
	}

	public void setPostcode(Postcode postcode) {
		this.postcode = postcode;
	}

	public static Person fromEntity(PersonEntity pe) {
		Person pm = new Person(pe.getName(), pe.getPostcode());
		return pm;
	}

	public PersonEntity toEntity() {
		PersonEntity pe = new PersonEntity(this.name,
				this.postcode.getPostcodeNumber());
		return pe;
	}

}

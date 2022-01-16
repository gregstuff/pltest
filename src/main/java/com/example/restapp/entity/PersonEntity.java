package com.example.restapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Person")
public class PersonEntity {

	public PersonEntity() {

	}

	public PersonEntity(Long id, String name, String postcode) {
		super();
		this.id = id;
		this.name = name;
		this.postcode = postcode;
	}

	private Long id;
	private String name;
	private String postcode;

	public PersonEntity(String name, String postcode) {
		this.name = name;
		this.postcode = postcode;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "postcode")
	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

}

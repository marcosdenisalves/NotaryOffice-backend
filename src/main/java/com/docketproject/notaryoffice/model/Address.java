package com.docketproject.notaryoffice.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String email;
	private String phoneNumber;
	private String street;
	private String city;
	private String state;
	private String country;

	@JsonIgnore
	@OneToOne(mappedBy = "address")
	private NotaryOffice notaryOffice;

	public Address() {
	}

	public Address(Long id, String email, String phoneNumber, String street, String city, String state, String country) {
		this.id = id;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.street = street;
		this.city = city;
		this.state = state;
		this.country = country;
	}
}

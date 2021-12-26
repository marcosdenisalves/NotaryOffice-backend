package com.docketproject.notaryoffice.dto;

import java.util.ArrayList;
import java.util.List;

import com.docketproject.notaryoffice.model.Certificate;

import lombok.Data;

@Data
public class NotaryOfficeDTO {

	private Long id;
	private String name;
	private String email;
	private String phone;
	private String street;
	private String city;
	private String state;
	private String country;

	private List<Certificate> certificates = new ArrayList<>();
}
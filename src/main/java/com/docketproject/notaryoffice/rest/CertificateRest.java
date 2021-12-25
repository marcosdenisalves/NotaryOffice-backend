package com.docketproject.notaryoffice.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.docketproject.notaryoffice.model.Certificate;
import com.docketproject.notaryoffice.service.CertificateService;

@RestController
@RequestMapping(value = "/certificates")
public class CertificateRest {
	
	@Autowired
	private CertificateService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Certificate>> findAll() {
		List<Certificate> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
}

package com.docketproject.notaryoffice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.docketproject.notaryoffice.model.Certificate;
import com.docketproject.notaryoffice.repository.CertificateRepository;

@Service
public class CertificateService {

	@Autowired
	private CertificateRepository repository;
	
	public List<Certificate> findAll() {
		return repository.findAll();
	}

	
}

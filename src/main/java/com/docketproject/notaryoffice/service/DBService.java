package com.docketproject.notaryoffice.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.docketproject.notaryoffice.model.Address;
import com.docketproject.notaryoffice.model.Certificate;
import com.docketproject.notaryoffice.model.NotaryOffice;
import com.docketproject.notaryoffice.repository.AddressRepository;
import com.docketproject.notaryoffice.repository.NotaryOfficeRepository;

@Service
public class DBService {

	@Autowired
	private NotaryOfficeRepository notaryOfficeRepository;

	@Autowired
	private AddressRepository addressRepository;

	public void instantiateTestDatabase() {

		Certificate cft1 = new Certificate(null, "2° Via de Certidão de Casamento");
		Certificate cft2 = new Certificate(null, "2° Via de Certidão de Nascimento");
		Certificate cft3 = new Certificate(null, "2° Via de Certidão de Óbito");
		
		Address ad1 = new Address(null, "l5uz8hpown@temporary-mail.net", "646-840-7896", "4338 Forest Avenue","New York", "New York" ,"USA");
		NotaryOffice nf1 = new NotaryOffice(null, "The Professional Notary.", ad1, Arrays.asList(cft1));

		ad1.setNotaryOffice(nf1);
		nf1.getCertificates().addAll(Arrays.asList(cft1, cft2, cft3));

		notaryOfficeRepository.save(nf1);
		addressRepository.save(ad1);
	}
}

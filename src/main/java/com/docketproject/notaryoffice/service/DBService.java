package com.docketproject.notaryoffice.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.docketproject.notaryoffice.model.Address;
import com.docketproject.notaryoffice.model.Certificate;
import com.docketproject.notaryoffice.model.NotaryOffice;
import com.docketproject.notaryoffice.repository.NotaryOfficeRepository;

@Service
public class DBService {

	@Autowired
	private NotaryOfficeRepository notaryOfficeRepository;

	public void instantiateTestDatabase() {
		
		notaryOfficeRepository.save(NotaryOffice.builder()
				.name("The Professional Notary.")
				.address(Address.builder()
						.email("l5uz8hpown@temporary-mail.net")
						.phoneNumber("646-840-7896")
						.street("4338 Forest Avenue")
						.city("New York")
						.state("New York")
						.country("USA")
						.build())
				.certificates(Arrays.asList(
						Certificate.builder().name("2° Via de Certidão de Casamento").build(),
						Certificate.builder().name("2° Via de Certidão de Nascimento").build(),
						Certificate.builder().name("2° Via de Certidão de Óbito").build()))
				.build());
	}
}

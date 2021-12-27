package com.docketproject.notaryoffice.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.docketproject.notaryoffice.dto.NotaryOfficeDTO;
import com.docketproject.notaryoffice.exception.ObjectNotFoundException;
import com.docketproject.notaryoffice.model.Address;
import com.docketproject.notaryoffice.model.Certificate;
import com.docketproject.notaryoffice.model.NotaryOffice;
import com.docketproject.notaryoffice.repository.CertificateRepository;
import com.docketproject.notaryoffice.repository.NotaryOfficeRepository;

@Service
public class NotaryOfficeService {

	@Autowired
	private NotaryOfficeRepository notaryOfficeRepository;
	
	@Autowired
	private CertificateRepository certificateRepository;

	public NotaryOffice findById(Long id) {
		Optional<NotaryOffice> obj = notaryOfficeRepository.findById(id);
		NotaryOffice notaryOffice = obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + NotaryOffice.class.getName(), null));

		return notaryOffice;
	}

	@Transactional
	public NotaryOffice insert(NotaryOfficeDTO objDto) {
		NotaryOffice obj = fromDTO(objDto);
		return notaryOfficeRepository.save(obj);
	}

	public NotaryOffice update(NotaryOfficeDTO objDto) {
		NotaryOffice obj = fromDTO(objDto);
		return notaryOfficeRepository.save(obj);
	}

	public void delete(Long id) {
		findById(id);
		notaryOfficeRepository.deleteById(id);
	}

	public List<NotaryOffice> findAll() {
		return notaryOfficeRepository.findAll();
	}

	private NotaryOffice fromDTO(NotaryOfficeDTO objDto) {
		return NotaryOffice.builder()
				.name(objDto.getName())
				.address(Address.builder()
						.email(objDto.getEmail())
						.phoneNumber(objDto.getPhone())
						.street(objDto.getStreet())
						.city(objDto.getCity())
						.state(objDto.getState())
						.country(objDto.getCountry()).build())
				.certificates(uploadCertificates(objDto.getCertificates())).build();
	}

	private List<Certificate> uploadCertificates(List<Certificate> certificates) {
		return this.certificateRepository.findAllById((Iterable<Long>)
				certificates.stream().map(x -> x.getId())
				.collect(Collectors.toList()));
	}
}

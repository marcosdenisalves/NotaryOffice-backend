package com.docketproject.notaryoffice.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class NotaryOffice implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id", referencedColumnName = "id")
	private Address address;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "certificate_by_notaryoffice",
			joinColumns = @JoinColumn(name = "notaryoffice_id"),
			inverseJoinColumns = @JoinColumn(name = "certificate_id"))
	private List<Certificate> certificates;

	public NotaryOffice() {
	}

	public NotaryOffice(Long id, String name, Address address, List<Certificate> certificates) {
		this.id = id;
		this.name = name;
		this.address = address;
		certificates.forEach(x -> addCertificate(x));
	}

	public void addCertificate(Certificate certificate) {
		if (certificate != null)
			if (certificates == null)
				certificates = new ArrayList<Certificate>();
		
		certificate.setId(null);
		this.certificates.add(certificate);
	}
}
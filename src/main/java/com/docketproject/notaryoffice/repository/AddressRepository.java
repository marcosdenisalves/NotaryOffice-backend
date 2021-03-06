package com.docketproject.notaryoffice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.docketproject.notaryoffice.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{

}

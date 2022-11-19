package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.entities.Address;
@Repository
public interface AddressDAO extends JpaRepository<Address, Integer>{

	public List<Address> findByCity(String city);
}

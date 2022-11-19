package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.entities.Address;
@Repository
public interface AddressDAO extends JpaRepository<Address, Integer>{

}

package com.masai.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.masai.DTO.AddressDTO;
import com.masai.entities.Address;

@Service
public interface AddressServiceaIntr {

	public Address addAddress(Integer vId,AddressDTO address);
	
	public Address updateAddress(Integer vId,AddressDTO address);
	
	public List<Address> getAddress(Integer vId);
}

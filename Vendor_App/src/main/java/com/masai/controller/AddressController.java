package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.DTO.AddressDTO;
import com.masai.entities.Address;
import com.masai.service.AddressServiceaIntr;
import com.masai.service.BankDetailsServiceIntr;
import com.masai.service.ContactsServiceIntr;
import com.masai.service.ProductServiceIntr;
import com.masai.service.VendorServiceIntr;

@RestController
public class AddressController {

	@Autowired
	private VendorServiceIntr vService;
	@Autowired
	private AddressServiceaIntr aService;
	@Autowired
	private ContactsServiceIntr cService;
	@Autowired
	private ProductServiceIntr pService;
	@Autowired
	private BankDetailsServiceIntr bService;
	
	

	//address
	@PostMapping(value = "/vendor/address/{vId}")
	public ResponseEntity<AddressDTO> saveVendorAddressDetails(@PathVariable("vId") Integer vId, @RequestBody AddressDTO address){
		AddressDTO c = aService.addAddress(vId, address);	
		return new ResponseEntity<AddressDTO>(c,HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/vendor/address/{id}")
	public ResponseEntity<Address> updateVendorAddressDetails(@PathVariable("id") Integer id, @RequestBody AddressDTO address){
		Address c = aService.updateAddress(id, address);	
		return new ResponseEntity<Address>(c,HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value = "/vendor/address/{id}")
	public ResponseEntity<List<Address>> getVendorAddressDetails(@PathVariable("id") Integer id){
		List<Address> vlist = aService.getAddress(id);	
		return new ResponseEntity<List<Address>>(vlist,HttpStatus.ACCEPTED);
	}
}

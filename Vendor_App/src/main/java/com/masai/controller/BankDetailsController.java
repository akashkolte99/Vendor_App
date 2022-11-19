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

import com.masai.DTO.BankDetailsDTO;
import com.masai.entities.BankDetails;
import com.masai.service.AddressServiceaIntr;
import com.masai.service.BankDetailsServiceIntr;
import com.masai.service.ContactsServiceIntr;
import com.masai.service.ProductServiceIntr;
import com.masai.service.VendorServiceIntr;

@RestController
public class BankDetailsController {

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
	
	

	// bankdetails
	
	@PostMapping(value = "/vendor/bankdetails/{vId}")
	public ResponseEntity<BankDetails> saveVendorBankDetails(@PathVariable("vId") Integer vId, @RequestBody BankDetailsDTO bank){
		BankDetails c = bService.addBankToVendor(vId, bank);	
		return new ResponseEntity<BankDetails>(c,HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/vendor/bankdetails/{id}")
	public ResponseEntity<BankDetails> updateVendorBankDetails(@PathVariable("id") Integer id, @RequestBody BankDetailsDTO bank){
		BankDetails c = bService.updateBankToVendor(id, bank);	
		return new ResponseEntity<BankDetails>(c,HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value = "/vendor/bankdetails/{id}")
	public ResponseEntity<List<BankDetails>> getVendorBankDetails(@PathVariable("id") Integer id){
		List<BankDetails> vlist = bService.getBankDetailsByVendorId(id);	
		return new ResponseEntity<List<BankDetails>>(vlist,HttpStatus.ACCEPTED);
	}
}

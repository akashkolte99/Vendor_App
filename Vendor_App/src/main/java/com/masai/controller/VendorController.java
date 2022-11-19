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
import com.masai.DTO.BankDetailsDTO;
import com.masai.DTO.VendorDTO;
import com.masai.DTO.VendorResponseDto;
import com.masai.entities.Address;
import com.masai.entities.BankDetails;
import com.masai.entities.Contacts;
import com.masai.entities.Vendor;
import com.masai.service.AddressServiceaIntr;
import com.masai.service.BankDetailsServiceIntr;
import com.masai.service.ContactsServiceIntr;
import com.masai.service.ProductServiceIntr;
import com.masai.service.VendorServiceIntr;

@RestController
public class VendorController {

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
	
	//vendor
	@PostMapping(value = "/vendor")
	public ResponseEntity<Vendor> saveVendorDetails(@RequestBody VendorDTO vendor){
		Vendor v = vService.createVendor(vendor);	
		return new ResponseEntity<Vendor>(v,HttpStatus.CREATED);
	}
	@GetMapping(value = "/vendor/{vendorName}")
	public ResponseEntity<List<VendorResponseDto>> getVendorDetailsByName(@PathVariable("vendorName") String vendorName){
		List<VendorResponseDto> vlist = vService.getVendorByName(vendorName);	
		return new ResponseEntity<List<VendorResponseDto>>(vlist,HttpStatus.ACCEPTED);
	}
	
	//contact
	@PostMapping(value = "/vendor/contact/{vId}/{contact}")
	public ResponseEntity<String> saveVendorContactDetails(@PathVariable("vId") Integer vId,@PathVariable("contact") String contact){
		String c = cService.addContact(vId, contact);	
		return new ResponseEntity<String>(c,HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/vendor/contacts/{id}")
	public ResponseEntity<List<Contacts>> getVendorContacts(@PathVariable("id") Integer id){
		List<Contacts> vlist = cService.getContactsOfVendor(id);	
		return new ResponseEntity<List<Contacts>>(vlist,HttpStatus.ACCEPTED);
	}
	
	
	//address
	@PostMapping(value = "/vendor/address/{vId}")
	public ResponseEntity<Address> saveVendorAddressDetails(@PathVariable("vId") Integer vId, @RequestBody AddressDTO address){
		Address c = aService.addAddress(vId, address);	
		return new ResponseEntity<Address>(c,HttpStatus.CREATED);
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

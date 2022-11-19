package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.entities.Contacts;
import com.masai.service.AddressServiceaIntr;
import com.masai.service.BankDetailsServiceIntr;
import com.masai.service.ContactsServiceIntr;
import com.masai.service.ProductServiceIntr;
import com.masai.service.VendorServiceIntr;

@RestController
public class ContactsController {

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
}

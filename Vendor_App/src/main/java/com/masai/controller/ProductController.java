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
import com.masai.DTO.ProductDTO;
import com.masai.DTO.ProductResponseDto;
import com.masai.entities.BankDetails;
import com.masai.entities.Product;
import com.masai.service.AddressServiceaIntr;
import com.masai.service.BankDetailsServiceIntr;
import com.masai.service.ContactsServiceIntr;
import com.masai.service.ProductServiceIntr;
import com.masai.service.VendorServiceIntr;
@RestController
public class ProductController {

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
	
	@PostMapping(value = "/vendor/products/{vId}")
	public ResponseEntity<Product> saveVendorProduct(@PathVariable("vId") Integer vId, @RequestBody ProductDTO product){
		Product c = pService.saveProduct(vId, product);	
		return new ResponseEntity<Product>(c,HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/vendor/products/{id}")
	public ResponseEntity<Product> updateVendorProducts(@PathVariable("id") Integer id, @RequestBody ProductDTO product){
		Product c = pService.updateProduct(id, product);	
		return new ResponseEntity<Product>(c,HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value = "/vendor/products/{name}")
	public ResponseEntity<List<ProductResponseDto>> getVendorBankProduct(@PathVariable("name") String name){
		List<ProductResponseDto> vlist = pService.poductsByName(name);	
		return new ResponseEntity<List<ProductResponseDto>>(vlist,HttpStatus.ACCEPTED);
	}
}

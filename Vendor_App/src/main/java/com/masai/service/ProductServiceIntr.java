package com.masai.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.masai.DTO.ProductDTO;
//import com.masai.DTO.ProductResponseDto;
import com.masai.DTO.VendorResponseDto;
import com.masai.entities.Product;

@Service
public interface ProductServiceIntr {

	public ProductDTO saveProduct(Integer vId,ProductDTO product);
	
	public Product updateProduct(Integer pId,ProductDTO product);
	
	public List<VendorResponseDto> poductsByName(String productname);
}

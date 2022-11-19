package com.masai.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.masai.DTO.ProductDTO;
import com.masai.DTO.ProductResponseDto;
import com.masai.entities.Product;

@Service
public interface ProductServiceIntr {

	public Product saveProduct(Integer vId,ProductDTO product);
	
	public Product updateProduct(Integer pId,ProductDTO product);
	
	public List<ProductResponseDto> poductsByName(String productname);
}

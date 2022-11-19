package com.masai.DTO;

import java.util.*;

import com.masai.entities.Vendor;

import lombok.Data;
@Data
public class ProductResponseDto {

	private Integer pId;
	private String productName;
	private List<Vendor> vlist= new ArrayList();
	
}

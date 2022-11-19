package com.masai.DTO;

import java.util.ArrayList;
import java.util.List;

import com.masai.entities.Product;

import lombok.Data;

@Data
public class VendorResponseDto {

	private Integer vendorId;
	private String vendorName;
	private List<Product> plist = new ArrayList<>();
}

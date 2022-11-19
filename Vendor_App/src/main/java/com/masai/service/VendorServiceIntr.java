package com.masai.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.masai.DTO.VendorDTO;
import com.masai.DTO.VendorResponseDto;
import com.masai.entities.Vendor;

@Service
public interface VendorServiceIntr {

	public Vendor createVendor(VendorDTO vendor);
	
	public List<VendorResponseDto> getVendorByName(String vendorName);
	
}

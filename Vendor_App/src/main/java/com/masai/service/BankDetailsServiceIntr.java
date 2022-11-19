package com.masai.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.masai.DTO.BankDetailsDTO;
import com.masai.entities.BankDetails;

@Service
public interface BankDetailsServiceIntr {

	public BankDetails addBankToVendor(Integer vId,BankDetailsDTO bank);
	
	public BankDetails updateBankToVendor(Integer bId,BankDetailsDTO bank);
	
	public List<BankDetails> getBankDetailsByVendorId(Integer vId);
	
}

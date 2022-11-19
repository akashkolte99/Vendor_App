package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.DTO.BankDetailsDTO;
import com.masai.entities.BankDetails;
import com.masai.entities.Vendor;
import com.masai.exception.NotFoundException;
import com.masai.repository.AddressDAO;
import com.masai.repository.BankDetailsDAO;
import com.masai.repository.VendorDAO;

@Service
public class BankDetailsServiceImpl  implements BankDetailsServiceIntr{

	@Autowired
	private VendorDAO vDao;
	
	@Autowired
	private AddressDAO aDao;
	
	@Autowired
	private BankDetailsDAO bDao;
	
	@Override
	public BankDetailsDTO addBankToVendor(Integer vId,BankDetailsDTO bank) {
		// TODO Auto-generated method stub
        Optional<Vendor> opt = vDao.findById(vId);
		
		if(opt.isEmpty()) {
			throw new NotFoundException("Vendor with this id is not found");
		}
		Vendor v = opt.get();
		
		BankDetails b = new BankDetails();
		b.setAccountNo(bank.getAccountNo());
		b.setBankName(bank.getBankName());
		b.setIfscCode(bank.getIfscCode());
		b.setVendor(v);
		v.getBankList().add(b);
		vDao.save(v);
		
		return bank;
	}

	@Override
	public BankDetails updateBankToVendor(Integer bId, BankDetailsDTO bank) {
		// TODO Auto-generated method stub
		Optional<BankDetails> opt = bDao.findById(bId);
		
		if(opt.isEmpty()) {
			throw new NotFoundException("Bank with this id is not found");
		}
		BankDetails b = new BankDetails();
		b.setAccountNo(bank.getAccountNo());
		b.setBankName(bank.getBankName());
		b.setIfscCode(bank.getIfscCode());
		return bDao.save(b);
	}

	@Override
	public List<BankDetails> getBankDetailsByVendorId(Integer vId) {
		// TODO Auto-generated method stub
	    Optional<Vendor> opt = vDao.findById(vId);
		
		if(opt.isEmpty()) {
			throw new NotFoundException("Vendor with this id is not found");
		}
		
		Vendor v = opt.get();
		List<BankDetails> blist = v.getBankList();
		if(blist.isEmpty()) {
			throw new NotFoundException("Banks not found for this vendor id "+vId);
		}
		return blist;
	}

}

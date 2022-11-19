package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entities.BankDetails;
import com.masai.entities.Contacts;
import com.masai.entities.Vendor;
import com.masai.exception.NotFoundException;
import com.masai.repository.AddressDAO;
import com.masai.repository.BankDetailsDAO;
import com.masai.repository.VendorDAO;

@Service
public class ContactsServiceImpl implements ContactsServiceIntr{


	@Autowired
	private VendorDAO vDao;
	
	@Autowired
	private AddressDAO aDao;
	
	@Autowired
	private BankDetailsDAO bDao;
	
	@Override
	public String addContact(Integer vId,String contact) {
		// TODO Auto-generated method stub
        Optional<Vendor> opt = vDao.findById(vId);
		
		if(opt.isEmpty()) {
			throw new NotFoundException("Vendor with this id is not found");
		}
		
		Vendor v = opt.get();
		Contacts c = new Contacts();
		c.setContactNumber(contact);
		c.setVendor(v);
		v.getContactList().add(c);
		vDao.save(v);
		return "Contact Number is added to Vender "+v.getVendorName();
	}

	@Override
	public List<Contacts> getContactsOfVendor(Integer vId) {
		// TODO Auto-generated method stub
		 Optional<Vendor> opt = vDao.findById(vId);
			
			if(opt.isEmpty()) {
				throw new NotFoundException("Vendor with this id is not found");
			}
			
			Vendor v = opt.get();
			List<Contacts> blist = v.getContactList();
			if(blist.isEmpty()) {
				throw new NotFoundException("Contacts  not found for this vendor id "+vId);
			}
			return blist;
	}

}

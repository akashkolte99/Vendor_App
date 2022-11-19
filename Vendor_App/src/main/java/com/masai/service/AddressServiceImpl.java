package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.DTO.AddressDTO;
import com.masai.entities.Address;
import com.masai.entities.Vendor;
import com.masai.exception.NotFoundException;
import com.masai.repository.AddressDAO;
import com.masai.repository.VendorDAO;

@Service
public class AddressServiceImpl implements AddressServiceaIntr{

	@Autowired
	private VendorDAO vDao;
	
	@Autowired
	private AddressDAO aDao;
	
	@Override
	public AddressDTO addAddress(Integer vId,AddressDTO address) {
		// TODO Auto-generated method stub
		Address a = new Address();
		a.setCity(address.getCity());
		a.setCountry(address.getCountry());
		a.setState(address.getState());
		
		Optional<Vendor> opt = vDao.findById(vId);
		
		if(opt.isEmpty()) {
			throw new NotFoundException("Vendor with this id is not found");
		}
		
		Vendor v = opt.get();
		v.getAddressList().add(a);
		a.setVendor(v);
		vDao.save(v);
		return address;
	}

	@Override
	public Address updateAddress(Integer aId,AddressDTO address) {
		// TODO Auto-generated method stub
		Optional<Address> opt = aDao.findById(aId);
		if(opt.isEmpty()) {
			throw new NotFoundException("Address with this id is not found");
		}
		Address a = opt.get();
		a.setCity(address.getCity());
		a.setCountry(address.getCountry());
		a.setState(address.getState());
		
		return aDao.save(a);
	}

	@Override
	public List<Address> getAddress(Integer vId) {
		// TODO Auto-generated method stub

		Optional<Vendor> opt = vDao.findById(vId);
		
		if(opt.isEmpty()) {
			throw new NotFoundException("Vendor with this id is not found");
		}
		
		Vendor v = opt.get();
		
		List<Address> alist = v.getAddressList();
		if(alist.isEmpty()) {
			throw new NotFoundException("Adress not found for this vendor id "+vId);
		}
		return alist;
	}

}

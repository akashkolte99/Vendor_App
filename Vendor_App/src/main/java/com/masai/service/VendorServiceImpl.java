package com.masai.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.DTO.VendorDTO;
import com.masai.DTO.VendorResponseDto;
import com.masai.entities.Address;
import com.masai.entities.Contacts;
import com.masai.entities.Product;
import com.masai.entities.Vendor;
import com.masai.exception.NotFoundException;
import com.masai.repository.AddressDAO;
import com.masai.repository.ProductDAO;
import com.masai.repository.VendorDAO;

@Service
public class VendorServiceImpl implements VendorServiceIntr{

	@Autowired
	private VendorDAO vDao;
	
	@Autowired
	private AddressDAO aDao;
	
	@Autowired
	private ProductDAO pDao;
	@Override
	public Vendor createVendor(VendorDTO vendor) {
		// TODO Auto-generated method stub
		Vendor v = new Vendor();
		v.setVendorName(vendor.getVendorName());
		
		Contacts c = new Contacts();
		c.setContactNumber(vendor.getContactNumber());
		c.setVendor(v);
		
		Address a = new Address();
		a.setCity(vendor.getCity());
		a.setState(vendor.getState());
		a.setCountry(vendor.getCountry());
		a.setVendor(v);
		
		v.getContactList().add(c);
		v.getAddressList().add(a);
		
		return vDao.save(v);
	}

	@Override
	public List<VendorResponseDto> getVendorByName(String vendorName) {
		// TODO Auto-generated method stub
		List<Vendor> vlist =  vDao.searchByNameLike(vendorName);
		if(vlist.isEmpty()) {
			throw new NotFoundException("No Vender Found With This Name");
		}
		List<VendorResponseDto> vrplists = new ArrayList<>();
		for(Vendor v : vlist) {
			VendorResponseDto vr = new VendorResponseDto();
			vr.setVendorId(v.getVId());
			vr.setVendorName(v.getVendorName());
			vr.getPlist().addAll(v.getProductList());
			
			vrplists.add(vr);
		}
		return vrplists;
	}
	
	@Override
	public List<VendorResponseDto> getVendorByCity(String city) {
		// TODO Auto-generated method stub
		List<Address> alist = aDao.findByCity(city);
		if(alist.isEmpty()) {
			throw new NotFoundException("No Vender Found In This City");
		}
		List<VendorResponseDto> vrplists = new ArrayList<>();
		for(Address a : alist) {
			VendorResponseDto vr = new VendorResponseDto();
			Vendor v = a.getVendor();
			vr.setVendorId(v.getVId());
			vr.setVendorName(v.getVendorName());
			vr.getPlist().addAll(v.getProductList());
			vrplists.add(vr);
		}
		return vrplists;
	}

	@Override
	public List<Vendor> getVendorList() {
		// TODO Auto-generated method stub
		List<Vendor> v = vDao.findAll();
		if(v.isEmpty()) {
			throw new NotFoundException("There Is No Vendor Found");
		}
		return v;
	}

}

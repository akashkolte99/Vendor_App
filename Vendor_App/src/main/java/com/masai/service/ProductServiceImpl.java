package com.masai.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.DTO.ProductDTO;

import com.masai.DTO.VendorResponseDto;
import com.masai.entities.Product;
import com.masai.entities.Vendor;
import com.masai.exception.NotFoundException;
import com.masai.repository.AddressDAO;
import com.masai.repository.ProductDAO;
import com.masai.repository.VendorDAO;


@Service
public class ProductServiceImpl implements ProductServiceIntr{

	@Autowired
	private VendorDAO vDao;
	
	@Autowired
	private ProductDAO pDao;
	
	
	@Override
	public ProductDTO saveProduct(Integer vId, ProductDTO product) {
		// TODO Auto-generated method stub
        Optional<Vendor> opt = vDao.findById(vId);
		
		if(opt.isEmpty()) {
			throw new NotFoundException("Vendor with this id is not found");
		}
		
		Vendor v = opt.get();
		
		Product  p = new Product();
		p.setProductName(product.getProductName());
		p.setDescription(product.getDescription());
		p.setPrice(product.getPrice());
		p.setVendor(v);
		v.getProductList().add(p);
		vDao.save(v);
		return product;
	}

	@Override
	public Product updateProduct(Integer pId, ProductDTO product) {
		// TODO Auto-generated method stub
		Optional<Product> opt = pDao.findById(pId);
		if(opt.isEmpty()) {
			throw new NotFoundException("Product Not Found With This Id");
		}
		Product  p = new Product();
		p.setProductName(product.getProductName());
		p.setDescription(product.getDescription());
		p.setPrice(product.getPrice());
		
		return pDao.save(p);
	}

	@Override
	public List<VendorResponseDto> poductsByName(String productname) {
		// TODO Auto-generated method stub
		List<Product> plist = pDao.searchByNameLike(productname);
		if(plist.isEmpty()) {
			throw new NotFoundException("Product With This Name Is Not Found");
		}
		
		List<VendorResponseDto> prdplist= new ArrayList<>();
		for(Product p : plist) {
			Vendor v = p.getVendor();
			VendorResponseDto vr = new VendorResponseDto();
			vr.setVendorId(v.getVId());
			vr.setVendorName(v.getVendorName());
			vr.setPlist(v.getProductList());
			
			prdplist.add(vr);
		}
		
		return prdplist;
	}
	
}

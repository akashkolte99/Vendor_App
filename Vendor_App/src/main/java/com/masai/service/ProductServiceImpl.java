package com.masai.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.DTO.ProductDTO;
import com.masai.DTO.ProductResponseDto;
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
	public Product saveProduct(Integer vId, ProductDTO product) {
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
		p.getVendorList().add(v);
		v.getProductList().add(p);
		vDao.save(v);
		return p;
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
	public List<ProductResponseDto> poductsByName(String productname) {
		// TODO Auto-generated method stub
		List<Product> plist = pDao.searchByNameLike(productname);
		if(plist.isEmpty()) {
			throw new NotFoundException("Product With This Name Is Not Found");
		}
		
		List<ProductResponseDto> prdplist= new ArrayList<>();
		for(Product p : plist) {
			ProductResponseDto pr = new ProductResponseDto();
			pr.setPId(p.getProductId());
			pr.setProductName(p.getProductName());
			pr.getVlist().addAll(p.getVendorList());
			prdplist.add(pr);
		}
		
		return prdplist;
	}
	
}

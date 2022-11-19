package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.masai.DTO.ProductDTO;
import com.masai.entities.Product;
import com.masai.entities.Vendor;
@Repository
public interface ProductDAO extends JpaRepository<Product, Integer>{
	public List<Product> findByPrice(String price);
	
	@Query("SELECT p FROM Product p WHERE p.productName LIKE %:name%")
	List<Product> searchByNameLike(@PathVariable("name") String name);
}

package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.masai.entities.Product;
import com.masai.entities.Vendor;
@Repository
public interface VendorDAO extends JpaRepository<Vendor, Integer>{

	@Query("SELECT v FROM Vendor v WHERE v.vendorName LIKE %:name%")
	List<Vendor> searchByNameLike(@PathVariable("name") String name);
}

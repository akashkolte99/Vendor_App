package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.entities.Vendor;
@Repository
public interface VendorDAO extends JpaRepository<Vendor, Integer>{

	public List<Vendor>  findByVendorName(String vendorName);
}
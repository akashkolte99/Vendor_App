package com.masai.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vendor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer vId;
	private String vendorName;
    
	@OneToMany(cascade = CascadeType.ALL , mappedBy = "vendor")
	private List<Address> addressList = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL , mappedBy = "vendor")
	private List<BankDetails> bankList = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL , mappedBy = "vendor")
	private List<Contacts> contactList = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL , mappedBy = "vendor")
	private List<Product> productList = new ArrayList<>();
}

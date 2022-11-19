package com.masai.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bId;
	private String accountNo;
	private String bankName;
	private String ifscCode;
	
	@JsonIgnore
	@ManyToOne
	private Vendor vendor;
}

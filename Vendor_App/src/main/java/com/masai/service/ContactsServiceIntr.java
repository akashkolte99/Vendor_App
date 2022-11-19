package com.masai.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.masai.entities.Contacts;

@Service
public interface ContactsServiceIntr {

	public String addContact(Integer vId,String contact);
	
	public List<Contacts> getContactsOfVendor(Integer vId);
}

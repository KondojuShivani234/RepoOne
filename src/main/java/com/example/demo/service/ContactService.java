package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Contact;



@Service
public interface ContactService {
	
	public String upsert(Contact contact); 
	
	public List<Contact> getAllContacts( );

	public Contact getContact(int cid);

	public String deleteContact(int cid);

}

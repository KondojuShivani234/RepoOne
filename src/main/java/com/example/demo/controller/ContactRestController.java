package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Contact;
import com.example.demo.service.ContactService;


@RestController
public class ContactRestController 

{
	@Autowired
	private ContactService contactservice;

	@PostMapping("/contact")
	public ResponseEntity<String> contact(@RequestBody Contact contact)
	{
		String status=contactservice.upsert(contact);
		return new ResponseEntity<String>(status,HttpStatus.CREATED);
	}
	@GetMapping("/contacts")
public ResponseEntity<List<Contact>> getAllContacts()
	{
		List<Contact> allContacts=contactservice.getAllContacts();
		return new ResponseEntity<>(allContacts, HttpStatus.OK);
	}
	@GetMapping("/contact/{cid}")
	public ResponseEntity<Contact> getContact(@PathVariable int cid){
		Contact contact=contactservice.getContact(cid);
		return new ResponseEntity<>(contact,HttpStatus.OK);
	}

	@DeleteMapping("/contact/{cid}")
	public ResponseEntity<String> deleteContact(@PathVariable int cid){
		String st=contactservice.deleteContact(cid);
		return new ResponseEntity<String>(st,HttpStatus.OK);
	}

	
}

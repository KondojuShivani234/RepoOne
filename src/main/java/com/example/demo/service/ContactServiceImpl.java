package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.ContactRepository;
import com.example.demo.model.Contact;
@Service
public class ContactServiceImpl implements ContactService 
{
	@Autowired
	private ContactRepository contactrepo;

	@Override
	public String upsert(Contact contact) {
		contactrepo.save(contact);
		return "SUCCESS";
	}

	@Override
	public List<Contact> getAllContacts() {
		// TODO Auto-generated method stub
		return contactrepo.findAll();
	}

	@Override
	public Contact getContact(int cid) {
		// TODO Auto-generated method stub
		Optional<Contact> findById = contactrepo.findById(cid);
		if(findById.isPresent())
		{
		return findById.get();
	}
	return null;
}
	@Override
	public String deleteContact(int cid) {
		// TODO Auto-generated method stub
		contactrepo.deleteById(cid);
		return "Success";
	}

}

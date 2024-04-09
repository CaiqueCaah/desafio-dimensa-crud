package br.com.caique.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.caique.crud.entities.Contact;
import br.com.caique.crud.repository.ContactRepository;

@Service
public class ContactService {
	
	@Autowired
	private ContactRepository contactRepository;

	public Contact create(Contact contact) {
		return contactRepository.save(contact);
	}
	
	public List<Contact> read() {
		Sort sort = Sort.by("name").ascending();
		
		return contactRepository.findAll(sort);
	}
	
	public List<Contact> update(Contact contact) {
		contactRepository.save(contact);
		
		return read();
	}
	
	public List<Contact> delete(Long id) {
		contactRepository.deleteById(id);
		
		return read();
	}
	
	public Contact findById(Long id) {
		return contactRepository.findById(id).get();
	}
	
}

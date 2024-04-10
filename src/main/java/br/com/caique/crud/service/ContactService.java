package br.com.caique.crud.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.caique.crud.entities.Address;
import br.com.caique.crud.entities.Contact;
import br.com.caique.crud.repository.ContactRepository;

@Service
public class ContactService {
	
	@Autowired
	private ContactRepository contactRepository;

	public void create(Contact contact) {
		
		Contact contactIn = new Contact(contact.getName(), contact.getEmail(), contact.getTelefone(), contact.getDataNascimento());
		
		List<Address> addresses = new ArrayList<>();
		
		for (Address addressIn : contact.getEndereco()) {
			Address address = new Address(addressIn.getRua(), addressIn.getNumero(), addressIn.getCep());
			
			address.setContact(contactIn);
			
			addresses.add(address);
		}
		
		contactIn.setEndereco(addresses);
		contactRepository.save(contactIn);
	}
	
	public List<Contact> read() {
		Sort sort = Sort.by("name").ascending();
		
		return contactRepository.findAll(sort);
	}
	
	public List<Contact> update(Contact contact) {
		if(contactRepository.existsById(contact.getId())) {
			contactRepository.save(contact);
		} else {
			throw new NoSuchElementException();
		}
		
		return read();
	}
	
	public List<Contact> delete(Long id) {
		if(contactRepository.existsById(id)) {
			contactRepository.deleteById(id);
		} else {
			throw new NoSuchElementException();
		}
		
		return read();
	}
	
	public Contact findById(Long id) {
		return contactRepository.findById(id).get();
	}
	
}

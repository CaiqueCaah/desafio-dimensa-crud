package br.com.caique.crud.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import br.com.caique.crud.controller.DTO.request.ContactRequestDTO;
import br.com.caique.crud.controller.DTO.response.ContactResponseDTO;
import br.com.caique.crud.entities.Contact;
import br.com.caique.crud.repository.ContactRepository;

@Service
public class ContactService {

	@Autowired
	private ContactRepository contactRepository;

	@Autowired
	private ModelMapper modelMapper;

	private static final Logger log = LoggerFactory.getLogger(ContactService.class);

	public ContactResponseDTO create(ContactRequestDTO contactRequestDTO) {
		log.info("Iniciando o cadastro do Contato");

		final var contact = modelMapper.map(contactRequestDTO, Contact.class);
		final var contactSave = contactRepository.save(contact);

		log.info("Contato salvo com sucesso !");

		return modelMapper.map(contactSave, ContactResponseDTO.class);
	}

	public List<Contact> read() {
		log.info("Buscando todos registros");

		Sort sort = Sort.by("name").ascending();
		var contacts = contactRepository.findAll(sort);

		log.info("Registros buscados com sucesso !");
		return contacts;
	}
	
	public ContactResponseDTO update(ContactRequestDTO contactRequestDTO, Long id) {
		if (contactRepository.existsById(id)) {
            log.info("Atualizando o contato");
            
            ContactRequestDTO contactUpdate =  modelMapper.map(contactRepository.findById(id), ContactRequestDTO.class);
           
            contactUpdate.setDataNascimento(contactRequestDTO.getDataNascimento());
            contactUpdate.setEmail(contactRequestDTO.getEmail());
            contactUpdate.setEndereco(contactRequestDTO.getEndereco());
            contactUpdate.setName(contactRequestDTO.getName());
            contactUpdate.setTelefone(contactRequestDTO.getTelefone());
            
            final var contactConvert = modelMapper.map(contactUpdate, Contact.class);
            
            log.info("Atualizado com sucesso");
            
            return modelMapper.map(contactRepository.save(contactConvert), ContactResponseDTO.class);
        } else {
            log.info("O contato com o id" + id + "não existe na base de dados");
            throw new NoSuchElementException();
        }
	}

	public List<Contact> delete(Long id) {
		log.info("Deletando o registro com o id: " + id);

		if (contactRepository.existsById(id)) {
			contactRepository.deleteById(id);

			log.info("Contato com o id" + id + "foi deletado !");
		} else {
			log.error("O contato com o id" + id + "não existe na base de dados");
			throw new NoSuchElementException();
		}

		return read();
	}

	public ContactResponseDTO findById(Long id) {
		log.info("Buscando o contato com o id: " + id);

		if (contactRepository.existsById(id)) {
			var contact = contactRepository.findById(id).get();
			log.info("Contato encontrado com sucesso !");

			return modelMapper.map(contact, ContactResponseDTO.class);
		} else {
			throw new NoSuchElementException();
		}

	}

}

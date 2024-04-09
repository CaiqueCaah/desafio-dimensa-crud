package br.com.caique.crud.controller.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.caique.crud.entities.Contact;
import br.com.caique.crud.service.ContactService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping(value = "/contacts")
public class ContactController {
	
	@Autowired
	private ContactService contactService;
	
	@Operation(summary = "Cria novos contatos.", method = "POST")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Contato criado com sucesso"),
			@ApiResponse(responseCode = "500", description = "Erro ao tentar criar o contato")
	})
	@PostMapping
	public Contact create(@RequestBody Contact contact) {
		return contactService.create(contact);
	}
	
	@Operation(summary = "Lista todos contatos salvos.", method = "GET")
	@GetMapping
	public List<Contact> read() {
		return contactService.read();
	}
	
	@Operation(summary = "Atualiza um contato.", method = "PUT")
	@PutMapping
	public List<Contact> update(@RequestBody Contact contact) {
		return contactService.update(contact);
	}
	
	@Operation(summary = "Deleta um contato.", method = "DELETE")
	@DeleteMapping("{id}")
	public List<Contact> delete(@PathVariable Long id) {
		return contactService.delete(id);
	}
	
	@Operation(summary = "Busca um contato com base no ID informado.", method = "GET")
	@GetMapping(value = "/{id}")
	public Contact findById(@PathVariable Long id) {
		return contactService.findById(id);
	}
}
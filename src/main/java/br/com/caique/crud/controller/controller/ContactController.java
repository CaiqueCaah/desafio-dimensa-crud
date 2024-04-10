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
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/contacts")
public class ContactController {
	
	@Autowired
	private ContactService contactService;
	
	@Operation(summary = "Cria novos contatos.", method = "POST")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Contato criado com sucesso"),
			@ApiResponse(responseCode = "400", description = "Erro ao tentar criar o contato")
	})
	@PostMapping
	public void create(@RequestBody @Valid Contact contact) {
		contactService.create(contact);
	}
	
	@Operation(summary = "Lista todos contatos salvos.", method = "GET")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Dados recuperados com sucesso"),
	})
	@GetMapping
	public List<Contact> read() {
		return contactService.read();
	}
	
	@Operation(summary = "Atualiza um contato.", method = "PUT")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Dados atualizados com sucesso"),
	})
	@PutMapping
	public List<Contact> update(@RequestBody Contact contact) {
		return contactService.update(contact);
	}
	
	@Operation(summary = "Deleta um contato.", method = "DELETE")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Dados deletados com sucesso"),
	})
	@DeleteMapping("{id}")
	public List<Contact> delete(@PathVariable Long id) {
		return contactService.delete(id);
	}
	
	@Operation(summary = "Busca um contato com base no ID informado.", method = "GET")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Dados recuperados com sucesso"),
			@ApiResponse(responseCode = "404", description = "Não existe na base de dados")
	})
	@GetMapping(value = "/{id}")
	public Contact findById(@PathVariable Long id) {
		return contactService.findById(id);
	}
}
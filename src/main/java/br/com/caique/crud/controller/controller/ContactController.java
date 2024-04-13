package br.com.caique.crud.controller.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.caique.crud.controller.DTO.request.ContactRequestDTO;
import br.com.caique.crud.controller.DTO.response.ContactResponseDTO;
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
			@ApiResponse(responseCode = "400", description = "Erro ao tentar criar o contato"),
			@ApiResponse(responseCode = "500", description = "Erro interno no sistema")
	})
	@PostMapping
	public ResponseEntity<ContactResponseDTO> create(@RequestBody ContactRequestDTO contactRequestDTO) {
		var contactSave = contactService.create(contactRequestDTO);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(contactSave);
	}
	
	@Operation(summary = "Lista todos contatos salvos.", method = "GET")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Dados recuperados com sucesso"),
			@ApiResponse(responseCode = "500", description = "Erro interno no sistema")
	})
	@GetMapping
	public List<Contact> read() {
		return contactService.read();
	}
	
	@Operation(summary = "Atualiza um contato.", method = "PUT")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Dados atualizados com sucesso"),
			@ApiResponse(responseCode = "404", description = "O contato não foi encontrado para atualização"),
			@ApiResponse(responseCode = "500", description = "Erro interno no sistema")
	})
	@PutMapping(value = "/{id}")
	public ContactResponseDTO update(@RequestBody ContactRequestDTO contactRequestDTO, @PathVariable Long id) {
		return contactService.update(contactRequestDTO, id);
	}
	
	@Operation(summary = "Deleta um contato.", method = "DELETE")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "204", description = "Dados deletados com sucesso"),
			@ApiResponse(responseCode = "404", description = "O contato não foi encontrado para a exclusão"),
			@ApiResponse(responseCode = "500", description = "Erro interno no sistema")
	})
	@DeleteMapping("{id}")
	public List<Contact> delete(@PathVariable Long id) {
		return contactService.delete(id);
	}
	
	@Operation(summary = "Busca um contato com base no ID informado.", method = "GET")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Dados recuperados com sucesso"),
			@ApiResponse(responseCode = "404", description = "Não existe na base de dados"),
			@ApiResponse(responseCode = "500", description = "Erro interno no sistema")
	})
	@GetMapping(value = "/{id}")
	public ContactResponseDTO findById(@PathVariable Long id) {
		return contactService.findById(id);
	}
}
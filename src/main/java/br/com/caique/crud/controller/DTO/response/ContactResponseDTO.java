package br.com.caique.crud.controller.DTO.response;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ContactResponseDTO {

	private Long id;

	private String name;

	private String email;

	private String telefone;

	private LocalDate dataNascimento;

	private List<AddressResponseDTO> endereco = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public List<AddressResponseDTO> getEndereco() {
		return endereco;
	}

	public void setEndereco(List<AddressResponseDTO> endereco) {
		this.endereco = endereco;
	}
}

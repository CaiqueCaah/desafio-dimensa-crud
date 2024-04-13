package br.com.caique.crud.controller.DTO.request;

import jakarta.persistence.Column;

public class AddressRequestDTO {

	@Column(nullable = false)
	private String rua;

	@Column(nullable = false)
	private int numero;

	@Column(nullable = false)
	private String cep;

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	
	
}

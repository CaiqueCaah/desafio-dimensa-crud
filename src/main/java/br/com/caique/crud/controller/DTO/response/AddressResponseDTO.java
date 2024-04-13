package br.com.caique.crud.controller.DTO.response;

public class AddressResponseDTO {

	private Long id;

	private String rua;

	private int numero;

	private String cep;

	public Long getId() {
		return id;
	}

	public String getRua() {
		return rua;
	}

	public void setId(Long id) {
		this.id = id;
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

package br.com.caique.crud;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.reactive.server.WebTestClient;

import br.com.caique.crud.entities.Address;
import br.com.caique.crud.entities.Contact;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class DesafioDimensaCrudApplicationTests {

	@Autowired
	private WebTestClient webTestClient;
	
	private final Address address = new Address("Rua teste", 1, "11111-111");
	private List<Address> addresses = new ArrayList<>();

	@Test
	void testeCreateContactSucess() {
		addresses.add(address);
		var contact = new Contact("João da Silva", "teste@teste.com", "1199999-9999", LocalDate.now(), addresses);

		webTestClient.post()
			.uri("/contacts")
			.bodyValue(contact)
			.exchange()
			.expectStatus().isCreated()
			.expectBody()
			.jsonPath("$.name").isEqualTo(contact.getName());
	}

	@Test
	void testeCreateContactFailure() {
		List<Address> addresses = new ArrayList<>();
		addresses.add(address);
		
		var contact = new Contact(null, null, null, LocalDate.now(), addresses);
		
		webTestClient.post()
		.uri("/contacts")
		.bodyValue(contact)
		.exchange()
		.expectStatus().isNotFound();
	}
	
	@Test
	void testeCreateGetContactSucess() {

		webTestClient.get()
			.uri("/contacts")
			.exchange()
			.expectStatus().isOk()
			.expectBody()
			.jsonPath("$").isArray()
			.jsonPath("$[0].name").isEqualTo("João da Silva Sauro");
	}
	
	@Test
	void testeCreateUpdateContactSucess() {
		addresses.add(address);
		var contact = new Contact("João da Silva Sauro", "teste@teste1.com", "1199999-9999", LocalDate.now(), addresses);

		webTestClient.put()
			.uri("/contacts/1")
			.bodyValue(contact)
			.exchange()
			.expectStatus().isOk()
			.expectBody()
			.jsonPath("$.name").isEqualTo(contact.getName());
	}
	
	@Test
	void testeUpdateContactFailure() {
		addresses.add(address);
		var contact = new Contact("João da Silva Sauro", "teste@teste1.com", "1199999-9999", LocalDate.now(), addresses);
		
		webTestClient.put()
		.uri("/contacts/555")
		.bodyValue(contact)
		.exchange()
		.expectStatus().isNotFound();
	}
	
	@Test
	void testeDeleteContactSucess() {
		webTestClient.delete()
			.uri("/contacts/1")
			.exchange()
			.expectStatus().isOk()
			.expectBody()
			.jsonPath("$.name").isEqualTo("João da Silva Sauro");
	}
	
	@Test
	void testeDeleteContactFailure() {
		webTestClient.delete()
		.uri("/contacts/555")
		.exchange()
		.expectStatus().isNotFound();
	}
	
	@Test
	void testeFindByIdContactSucess() {
		webTestClient.get()
			.uri("/contacts/1")
			.exchange()
			.expectStatus().isOk()
			.expectBody()
			.jsonPath("$.name").isEqualTo("João da Silva Sauro");
	}
	
	@Test
	void testeFindByIdContactFailure() {
		webTestClient.get()
		.uri("/contacts/555")
		.exchange()
		.expectStatus().isNotFound();
	}
}

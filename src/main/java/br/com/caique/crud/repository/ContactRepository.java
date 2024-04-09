package br.com.caique.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.caique.crud.entities.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long>{

}
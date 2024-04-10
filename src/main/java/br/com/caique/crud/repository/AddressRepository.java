package br.com.caique.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.caique.crud.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

}
package br.com.accountbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.accountbank.model.CardType;
// import  java.util.Optional;

@Repository
public interface CardTypeRepository extends JpaRepository<CardType, Integer> {
	
	//Optional< CardType >  findByName ( String  name );

}
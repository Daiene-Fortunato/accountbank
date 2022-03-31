package br.com.accountbank.service;


import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.accountbank.model.Card;
import br.com.accountbank.repository.CardRepository;

@Service
public class CardService {

	 @Autowired
	 private CardRepository cardRepository;
	 
	 public Card findById(Integer id) {
		 return cardRepository.findById(id)
				 .orElseThrow(() -> new EntityNotFoundException("This card id: "+id+" not found"));
	 }
	 
	 public void delete(Integer id) {
		 cardRepository.deleteById(id);
	 }
		 
}

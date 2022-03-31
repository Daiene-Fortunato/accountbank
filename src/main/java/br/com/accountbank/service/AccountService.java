package br.com.accountbank.service;


import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.accountbank.handler.AccountAlreadyExistsException;
import br.com.accountbank.handler.CardAlreadyExistsException;
import br.com.accountbank.handler.ExistsCardInAccountException;
import br.com.accountbank.model.Account;
import br.com.accountbank.model.Card;
import br.com.accountbank.repository.AccountRepository;
import br.com.accountbank.repository.CardRepository;


@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CardRepository cardRepository;
    
    
    //------- CREATE ----------
    public Account save(Account account) {
    	Optional<Account> accExists = accountRepository.findByRegisterId(account.getRegisterId());
    	if (accExists.isPresent())
    		throw new AccountAlreadyExistsException();
        return accountRepository.save(account);
    }
    
    //------ READ by Id --------
    public Account findById(Integer id) {
        return accountRepository.findById(id)
        		.orElseThrow(() -> new EntityNotFoundException("This account id: "+id+" not found"));
    }


    //------ ADD CARD To Account
    public Account addCard(Integer id, Card card) {
    	Optional<Card> cardExists = cardRepository.findByNumber(card.getNumber());
    	if (cardExists.isPresent())
    		throw new CardAlreadyExistsException();
        Account account = findById(id);
        account.addCard(card);
        return accountRepository.save(account);
    }

    //------ DELETE by Id ----------
    public void delete(Integer id) {
        Account account = findById(id);
        if(!account.getCards().isEmpty()) {
            throw new ExistsCardInAccountException();
        } accountRepository.deleteById(id);
    }

}
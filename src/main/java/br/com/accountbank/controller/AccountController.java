package br.com.accountbank.controller;

import br.com.accountbank.model.Account;
import br.com.accountbank.model.Card;
import br.com.accountbank.repository.AccountRepository;
import br.com.accountbank.service.AccountService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {
    
	@Autowired
    private AccountRepository accountRepository;
	
	@Autowired
	private AccountService accountService;

    //POST - CREATE
    @ApiOperation(value = "Create an Account")
    @PostMapping
    public ResponseEntity<Account> save(@Valid @RequestBody Account account) {
        Account acc = accountService.save(account);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(acc.getId())
                .toUri();
        return ResponseEntity.created(location).body(acc);
    }
    

    //GET - READ ALL
    @ApiOperation(value = "List All Accounts")
    @GetMapping("/all")
    public List<Account> GetAccount() {
    	return accountRepository.findAll();
    }

    //GET - READ BY ID
    @ApiOperation(value = "Read Account by Id")
    @GetMapping("/{id}")
    public ResponseEntity<Account> findById(@PathVariable("id") Integer id) {

        Account account = accountService.findById(id);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }
    
    
    //POST - ADD CARD
    @ApiOperation(value="Add card to account")
    @PutMapping("/addcard/{id}")
    public ResponseEntity<Account> addCard(@PathVariable("id") Integer id, @Valid @RequestBody Card card) {
        Account acc = accountService.addCard(id, card);
        return new ResponseEntity<Account>(acc, HttpStatus.OK);
    }

    //DELETE - DELETE BY ID
    @ApiOperation(value = "Delete Account by Id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        accountService.delete(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}

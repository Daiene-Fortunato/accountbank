package br.com.accountbank.controller;

import br.com.accountbank.model.Account;
import br.com.accountbank.repository.AccountRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {
    
	@Autowired
    private AccountRepository accountRepository;

    //POST - CREATE
    @ApiOperation(value = "Create an Account")
    @PostMapping
    public Account PostAccount(@RequestBody Account account) {
    	return accountRepository.save(account);
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
    public Account GetAccount(@PathVariable Integer id) {
    	return accountRepository.findById(id).orElseThrow(
    			() -> new RuntimeException("Account not found."));
    }

    //PUT - UPDATE BY ID
    @ApiOperation(value = "Update Account by Id")
    @PutMapping("/{id}")
    public Account PutAccount(@RequestBody Account account) {
        Account oldAccount = accountRepository.findById(account.getId()).orElseThrow(
        		() -> new RuntimeException("Account not found."));
        oldAccount.setNameOwner(account.getNameOwner());
        oldAccount.setAgencyCode(account.getAgencyCode());
        oldAccount.setAccountCode(account.getAccountCode());
        oldAccount.setVerificationDigit(account.getVerificationDigit());
        oldAccount.setRegisterId(account.getRegisterId());
        return accountRepository.save(oldAccount);
    }

    //DELETE - DELETE BY ID
    @ApiOperation(value = "Delete Account by Id")
    @DeleteMapping("/{id}")
    public Integer DeleteAccount(@PathVariable Integer id) {
    	accountRepository.deleteById(id);
    	return id;
    }

}

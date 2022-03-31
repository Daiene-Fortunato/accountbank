package br.com.accountbank.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.accountbank.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
	
	Optional<Account> findByRegisterId(String registerId);

}
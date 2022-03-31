package br.com.accountbank.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import br.com.accountbank.model.Card;

@Repository
@EnableJpaRepositories
public interface CardRepository extends JpaRepository<Card, Integer> {

	Optional<Card> findByNumber(String number);
	Optional<Card> findById(Integer id);
}

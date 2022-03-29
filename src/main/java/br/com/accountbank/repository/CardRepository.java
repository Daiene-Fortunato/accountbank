package br.com.accountbank.repository;

// import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.accountbank.model.Card;

@Repository
public interface CardRepository extends JpaRepository<Card, Integer> {

	// Optional<Card> findById(Integer cardId);

}

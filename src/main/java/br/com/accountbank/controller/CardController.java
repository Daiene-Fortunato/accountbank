package br.com.accountbank.controller;

import br.com.accountbank.model.Card;
import br.com.accountbank.repository.CardRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cards")
public class CardController {

	@Autowired
    private CardRepository cardRepository;

    //POST - CREATE
    @ApiOperation(value = "Create an card")
    @PostMapping
    public Card PostCard(@RequestBody Card card) {
    	return cardRepository.save(card);
    }

    //GET - READ ALL
    @ApiOperation(value = "List All Cards")
    @GetMapping("/all")
    public List<Card> GetCard() {
    	return cardRepository.findAll();
    }

    //GET - READ BY ID
    @ApiOperation(value = "Read cards by Id")
    @GetMapping("/{id}")
    public Card GetCard(@PathVariable Integer id) {
    	return cardRepository.findById(id).orElseThrow(() -> new RuntimeException("Card not found."));
    }

    //PUT - UPDATE BY ID
    @ApiOperation(value = "Update Cards by Id")
    @PutMapping("/{id}")
    public Card PutCard(@RequestBody Card card) {
        Card oldCard = cardRepository.findById(card.getId()).orElseThrow(
        		() -> new RuntimeException("Card not found."));
        oldCard.setName(card.getName());
        oldCard.setFlag(card.getFlag());
        oldCard.setCardType(card.getCardType());
        oldCard.setNumber(card.getNumber());
        oldCard.setDigitCode(card.getDigitCode());
        oldCard.setLimitBalance(card.getLimitBalance());
        oldCard.setAccount(card.getAccount());
        return cardRepository.save(oldCard);
    }

    //DELETE - DELETE BY ID
    @ApiOperation(value = "Delete Cards by Id")
    @DeleteMapping("/{id}")
    public Integer DeleteCard(@PathVariable Integer id) {
    	cardRepository.deleteById(id);
    	return id;
    }

}

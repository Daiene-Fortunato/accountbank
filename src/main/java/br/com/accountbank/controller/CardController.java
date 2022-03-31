package br.com.accountbank.controller;

import br.com.accountbank.model.Card;
import br.com.accountbank.repository.CardRepository;
import br.com.accountbank.service.CardService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cards")
public class CardController {

	@Autowired
    private CardRepository cardRepository;
	
	@Autowired
	private CardService cardService;


    //GET - READ ALL
    @ApiOperation(value = "List All Cards")
    @GetMapping("/all")
    public List<Card> GetCard() {
    	return cardRepository.findAll();
    }

    //GET - READ BY ID
    @ApiOperation(value = "Read cards by Id")
    @GetMapping("/{id}")
    public ResponseEntity<Card> findById(@PathVariable("id") Integer id) {
        Card card = cardService.findById(id);
        return new ResponseEntity<>(card, HttpStatus.OK);
    }

    //DELETE - DELETE BY ID
    @ApiOperation(value = "Delete Cards by Id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        cardService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

package br.com.accountbank.controller;

import br.com.accountbank.model.CardType;
import br.com.accountbank.repository.CardTypeRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//import java.util.List;

@RestController
@RequestMapping("/api/v1/cardTypes")
public class CardTypeController {
    
	@Autowired
    private CardTypeRepository cardTypeRepository;

//    //POST - CREATE
//    @ApiOperation(value = "Create an Card Type")
//    @PostMapping
//    public CardType PostCardType(@RequestBody CardType cardType) {
//    	return cardTypeRepository.save(cardType);
//    }

//    //GET - READ ALL
//    @ApiOperation(value = "List All Card Types")
//    @GetMapping("/all")
//    public List<CardType> GetCardType() {
//    	return cardTypeRepository.findAll();
//    }

//    //GET - READ BY ID
//    @ApiOperation(value = "Read Card Types by Id")
//    @GetMapping("/{id}")
//    public CardType GetCardType(@PathVariable Integer id) {
//    	return cardTypeRepository.findById(id).orElseThrow(() -> new RuntimeException("Card Type not found."));
//    }

    //PUT - UPDATE BY ID
    @ApiOperation(value = "Update Card Types by Id")
    @PutMapping("/{id}")
    public CardType PutCardType(@RequestBody CardType cardType) {
        CardType oldCardType = cardTypeRepository.findById(cardType.getId()).orElseThrow(
        		() -> new RuntimeException("CardType not found."));
        oldCardType.setName(cardType.getName());
        return cardTypeRepository.save(oldCardType);
    }

//    //DELETE - DELETE BY ID
//    @ApiOperation(value = "Delete Card Types by Id")
//    @DeleteMapping("/{id}")
//    public Integer DeleteCardType(@PathVariable Integer id) {
//    	cardTypeRepository.deleteById(id);
//    	return id;
//    }

}

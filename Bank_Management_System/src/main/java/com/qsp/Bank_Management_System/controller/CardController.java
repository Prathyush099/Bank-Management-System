package com.qsp.Bank_Management_System.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.Bank_Management_System.dto.Card;
import com.qsp.Bank_Management_System.service.CardService;
import com.qsp.Bank_Management_System.util.ResponseStructure;
import com.qsp.Bank_Management_System.util.ResponseStructureList;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class CardController {
	
	@Autowired
	CardService CardService;

	@Operation(summary = "Save Card", description = "API is used to save the Cards")
	@ApiResponses(value = {@ApiResponse(responseCode = "201", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Card not found for the given id") })
	@PostMapping("/saveCard")
	public ResponseStructure<Card> saveCard(@RequestBody Card Card)
	{
		return CardService.saveCard(Card);

	}
	
	@Operation(summary = "Fetch Card", description = "API is used to find the Cards")
	@ApiResponses(value = {@ApiResponse(responseCode = "302", description = "Successfully Fetched "),
			@ApiResponse(responseCode = "404", description = "Card not found for the given id") })
	@GetMapping("/fetchCardById")
	public ResponseStructure<Card> fetchCardById(@RequestParam int CardId) {
		return CardService.fetchCardById(CardId);
		
	}
	
	@Operation(summary = "Delete Card", description = "API is used to delete the Card")
	@ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Card not found for the given id") })
	@DeleteMapping("/deleteCardById")
	public ResponseStructure<Card> deleteCardById(int CardId) {
		return CardService.deleteCardById(CardId);
		
	}
	
	@Operation(summary = "Update Card", description = "API is used to Update the Card details")
	@ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Card not found for the given id") })
	@PutMapping("/updateCardById")
	public ResponseStructure<Card> updateCardById(@RequestParam int oldCardId ,@RequestBody Card newCard) {
		return CardService.updateCardById(oldCardId, newCard);
	}
	
	
	@Operation(summary = "Fetch All Cards", description = "API is used to find all the Cards")
	@ApiResponses(value = {@ApiResponse(responseCode = "302", description = "Successfully Fetched "),
			@ApiResponse(responseCode = "404", description = "Cards not found") })
	@GetMapping("/fetchAllCards")
	public ResponseStructureList<Card> fetchAllCards() {
		return CardService.fetchAllCards();
		
	}


}

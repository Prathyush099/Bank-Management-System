package com.qsp.Bank_Management_System.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.Bank_Management_System.dto.Card;
import com.qsp.Bank_Management_System.repo.CardRepo;

@Repository
public class CardDao {
	
	@Autowired
	CardRepo cardRepo;

	public Card saveCard(Card Card) 
	{
		return cardRepo.save(Card);

	}
	
	public Card fetchCardById(int CardId) {
		Optional<Card> card = cardRepo.findById(CardId);
		if (card.isPresent()) {
			return card.get();
		}else {
			 return null;
		}
	}
	
	public Card deleteCardById(int CardId) {
		Optional<Card> card= cardRepo.findById(CardId);
		if (card.isPresent()) {
			cardRepo.delete(card.get()); 
	        return card.get();
	    } else {
	        return null;
	    }
	}
	
	public Card updateCardById(int oldCardId,Card newCardId) {
		newCardId.setCardId(oldCardId);
		Optional<Card> card= cardRepo.findById(oldCardId);
		if (card.isPresent()) {
			return cardRepo.save(newCardId);
		}else {
			 return null;
		}
	}
	
	public List<Card> fetchAllCards() {
		return cardRepo.findAll();
		
	}

}

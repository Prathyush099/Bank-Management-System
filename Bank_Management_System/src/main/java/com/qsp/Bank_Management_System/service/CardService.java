package com.qsp.Bank_Management_System.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.Bank_Management_System.dao.CardDao;
import com.qsp.Bank_Management_System.dto.Card;
import com.qsp.Bank_Management_System.exception.CardIdNotFound;
import com.qsp.Bank_Management_System.util.ResponseStructure;
import com.qsp.Bank_Management_System.util.ResponseStructureList;

@Service
public class CardService {
	
	@Autowired
	CardDao cardDao;
	
	@Autowired
	ResponseStructure<Card> responseStructure;
	
	@Autowired
	ResponseStructureList<Card> responseStructureList;

	public ResponseStructure<Card> saveCard(Card Card) {
		responseStructure.setMessage("Card has being inserted");
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(cardDao.saveCard(Card));
		return responseStructure;

	}
	
	public ResponseStructure<Card> fetchCardById(int CardId) {
		Card card = cardDao.deleteCardById(CardId);
		if (card != null) {
		responseStructure.setMessage("Card has being Fetched");
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setData(cardDao.fetchCardById(CardId));
		return responseStructure;
		} else {
			throw new CardIdNotFound();
		}
		
	}
	
	public ResponseStructure<Card> deleteCardById(int CardId) {
		Card card = cardDao.deleteCardById(CardId);
		if (card != null) {
		responseStructure.setMessage("This respective Card has being Deleted from DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(cardDao.deleteCardById(CardId));
		return responseStructure;
		} else {
			throw new CardIdNotFound();
		}
		
	}
	
	public ResponseStructure<Card> updateCardById(int oldCardId ,Card newCard) {
		Card card = cardDao.deleteCardById(oldCardId);
		if (card != null) {
		responseStructure.setMessage("This respective Card is Updated in DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(cardDao.updateCardById(oldCardId, newCard));
		return responseStructure;
		} else {
			throw new CardIdNotFound();
		}
		
		
	}
	
	public ResponseStructureList<Card> fetchAllCards() {
		responseStructureList.setMessage("All the Employee has being Fetched from DB");
		responseStructureList.setStatusCode(HttpStatus.OK.value());
		responseStructureList.setData(cardDao.fetchAllCards());
		return responseStructureList;
		
	}

}

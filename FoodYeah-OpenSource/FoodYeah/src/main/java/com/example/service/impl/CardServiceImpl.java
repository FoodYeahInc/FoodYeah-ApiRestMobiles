package com.example.service.impl;

import com.example.entity.Card;
import com.example.repository.CardRepository;
import com.example.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardServiceImpl implements CardService {
    @Autowired
    private CardRepository cardRepository;

    @Override
    public List<Card> findCardAll() {
        return cardRepository.findAll();
    }

    @Override
    public Card getCard(Long id) {
        return cardRepository.findById(id).orElse(null);
    }

    @Override
    public Card createCard(Card card) {
        Card cardDB=this.getCard(card.getId());
        if(cardDB!=null){
            return cardDB;
        }
        cardDB.setState("CREATED");
        cardDB=cardRepository.save(card);
        return cardDB;
    }

    @Override
    public Card updateCard(Card card) {
        Card cardDB=this.getCard(card.getId());
        if(cardDB==null){
            return null;
        }
        cardDB.setCustomer(card.getCustomer());
        cardDB.setCardNumber(card.getCardNumber());
        cardDB.setCardCvi(card.getCardCvi());
        cardDB.setCardOwnerName(card.getCardOwnerName());
        cardDB.setCardExpireDate(card.getCardExpireDate());
        cardDB.setState("UPDATED");
        return cardRepository.save(cardDB);
    }

    @Override
    public Card deleteCard(Card card) {
        Card cardDB=this.getCard(card.getId());
        if(cardDB==null){
            return null;
        }
        card.setState("DELETED");
        return cardRepository.save(card);
    }
}

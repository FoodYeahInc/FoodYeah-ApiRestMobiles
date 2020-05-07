package com.example.service;

import com.example.entity.Card;
import com.example.entity.Customer;
import java.util.List;

public interface CardService {
    List<Card> findCardAll();
    Card getCard(Long id);

    List<Card> findByCustomer(Customer costumer);


    Card createCard(Card card);
    Card updateCard(Card card);
    Card deleteCard(Long id);

}

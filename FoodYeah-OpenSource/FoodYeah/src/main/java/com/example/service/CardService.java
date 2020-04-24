package com.example.service;

import com.example.entity.Card;

import antlr.collections.List;

public interface CardService {
    List<Card> findCardAll();

    Card createCard();
    Card updateCard();
    void deleteCard();

    Card getCard(int id);
    // DataCollection<Card> GetAll(int page, int take);
    // Card GetById(int id);
    // Card Create(CardCreateDto model);
    // void Update(int id, CardUpdateDto model);
    // void Remove(int id);
}

package com.chento.card.service;

import com.chento.card.entity.Card;

import java.util.List;

public interface CardService {
    Card save(Card loan);

    List<Card> getList();

    List<Card> getByCustomerId(Long customerId);
}

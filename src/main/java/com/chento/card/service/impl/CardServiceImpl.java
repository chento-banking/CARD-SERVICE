package com.chento.card.service.impl;

import com.chento.card.entity.Card;
import com.chento.card.repository.CardRepository;
import com.chento.card.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CardServiceImpl implements CardService {

    private final CardRepository loanRepository;
    @Override
    public Card save(Card card) {
        return loanRepository.save(card);
    }
    @Override
    public List<Card> getList() {
        return loanRepository.findAll();
    }
    @Override
    public List<Card> getByCustomerId(Long customerId) {
        return loanRepository.findByCustomerId(customerId);
    }

}
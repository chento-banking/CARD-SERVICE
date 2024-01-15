package com.chento.card.repository;

import com.chento.card.entity.Card;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CardRepository extends MongoRepository<Card,Long> {
    List<Card> findByCustomerId(Long customerId);
}

package com.chento.card.controller;


import java.util.List;

import com.chento.card.dto.CardDTO;
import com.chento.card.entity.Card;
import com.chento.card.mapper.CardMapper;
import com.chento.card.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/cards")
public class CardController {

    private final CardService cardService;
    private final CardMapper cardMapper;

    @PostMapping
    public  ResponseEntity<?> save(@RequestBody CardDTO dto){
        Card card = cardService.save(cardMapper.toCard(dto));
        return ResponseEntity.status(HttpStatus.CREATED).body(card);
    }

    @GetMapping
    public ResponseEntity<?> list(){
        return ResponseEntity.ok(cardService.getList());
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<List<Card>> getByCustomerId(
            @RequestHeader("chentobank-corelation-id") String correlationId,
            @PathVariable Long customerId){

        log.debug("correlation-idf found: {}",correlationId);

        return ResponseEntity.ok(cardService.getByCustomerId(customerId));

    }
}

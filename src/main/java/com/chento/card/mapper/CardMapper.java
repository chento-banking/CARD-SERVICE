package com.chento.card.mapper;

import com.chento.card.dto.CardDTO;
import com.chento.card.entity.Card;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CardMapper {

    Card toCard(CardDTO dto);

}

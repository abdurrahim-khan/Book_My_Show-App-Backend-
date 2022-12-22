package com.example.bookmyshow.converter;

import com.example.bookmyshow.dto.responsedto.TicketDto;
import com.example.bookmyshow.model.TicketEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TicketConverter {
    public static TicketDto entityToDto(TicketEntity ticketEntity)
    {
        return TicketDto.builder().id(ticketEntity.getTkt_id()).allottedSeats(ticketEntity.getAllotted_seat()).amount(ticketEntity.getAmount()).showResponseDto(ShowConverter.entityToDto(ticketEntity.getShowEntity())).userResponseDto(UserConverter.entityToDto(ticketEntity.getUser())).build();
    }
}

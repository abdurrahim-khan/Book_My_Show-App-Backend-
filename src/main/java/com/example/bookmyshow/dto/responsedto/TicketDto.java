package com.example.bookmyshow.dto.responsedto;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TicketDto {
    private int id; //ticket id
    private String allottedSeats;
    private double amount;
    private ShowResponseDto showResponseDto;
    private UserResponseDto userResponseDto;

}

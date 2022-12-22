package com.example.bookmyshow.dto.responsedto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShowResponseDto {
    private int id;
    private LocalDate showdate;
    private LocalTime showtime;
    private MovieResponseDto movieResponseDto;
    private TheatreResponseDto theatreResponseDto;
}

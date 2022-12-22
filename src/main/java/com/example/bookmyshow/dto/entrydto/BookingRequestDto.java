package com.example.bookmyshow.dto.entrydto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookingRequestDto {
    private int user_id;
    private int show_id;
    private Set<String> requestedSeats;
}

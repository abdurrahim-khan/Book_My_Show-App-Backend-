package com.example.bookmyshow.dto.entrydto;

import com.example.bookmyshow.dto.responsedto.TheatreResponseDto;
import com.example.bookmyshow.dto.responsedto.MovieResponseDto;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShowEntryDto {
    @NonNull
    private LocalDate showdate;
    @NonNull
    private LocalTime showtime;
    @NonNull
    private MovieResponseDto movieResponseDto;
    @NonNull
    private TheatreResponseDto theatreResponseDto;
}

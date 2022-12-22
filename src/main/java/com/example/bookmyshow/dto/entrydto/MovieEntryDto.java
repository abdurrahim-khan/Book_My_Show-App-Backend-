package com.example.bookmyshow.dto.entrydto;

import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieEntryDto {
    @NonNull
    private String name;
    @NonNull
    private LocalDate releaseDate;
}

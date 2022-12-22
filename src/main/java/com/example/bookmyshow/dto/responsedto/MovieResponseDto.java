package com.example.bookmyshow.dto.responsedto;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class MovieResponseDto {
    private int id;
    private String name;
    private LocalDate releaseDate;
}

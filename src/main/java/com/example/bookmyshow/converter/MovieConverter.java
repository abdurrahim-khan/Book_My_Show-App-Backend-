package com.example.bookmyshow.converter;

import com.example.bookmyshow.dto.entrydto.MovieEntryDto;
import com.example.bookmyshow.dto.responsedto.MovieResponseDto;
import com.example.bookmyshow.model.MovieEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class MovieConverter {
    public static MovieEntity dtoToEntity(MovieEntryDto movieEntryDto)
    {
        return MovieEntity.builder().name(movieEntryDto.getName()).releaseDate(movieEntryDto.getReleaseDate()).build();
    }
    public static MovieResponseDto entityToDto(MovieEntity movieEntity)
    {

       return MovieResponseDto.builder().id(movieEntity.getMovie_id()).name(movieEntity.getName()).releaseDate(movieEntity.getReleaseDate()).build();
    }
}

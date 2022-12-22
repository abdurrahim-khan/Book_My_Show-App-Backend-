package com.example.bookmyshow.service;

import com.example.bookmyshow.dto.entrydto.MovieEntryDto;
import com.example.bookmyshow.dto.responsedto.MovieResponseDto;

public interface MovieService {
    public void addMovie(MovieEntryDto movieEntryDto);
    public MovieResponseDto getMovie(int id);
}

package com.example.bookmyshow.service;

import com.example.bookmyshow.dto.entrydto.TheatreEntryDto;
import com.example.bookmyshow.dto.responsedto.TheatreResponseDto;

public interface TheatreService {
    public void addTheatre(TheatreEntryDto theatreEntryDto);
    public TheatreResponseDto getTheatre(int id);
}

package com.example.bookmyshow.service;

import com.example.bookmyshow.dto.entrydto.ShowEntryDto;
import com.example.bookmyshow.dto.responsedto.ShowResponseDto;

public interface ShowService {
    //getshow
    public ShowResponseDto getShow(int showId);

    //addShow
    public void addShow(ShowEntryDto showEntryDto);
}

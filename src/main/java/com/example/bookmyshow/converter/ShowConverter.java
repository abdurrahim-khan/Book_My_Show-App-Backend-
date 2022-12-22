package com.example.bookmyshow.converter;

import com.example.bookmyshow.dto.entrydto.ShowEntryDto;
import com.example.bookmyshow.dto.responsedto.ShowResponseDto;
import com.example.bookmyshow.model.ShowEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ShowConverter {
    public ShowResponseDto entityToDto(ShowEntity showEntity)
    {
        return ShowResponseDto.builder().id(showEntity.getShow_id()).showdate(showEntity.getShow_date()).showtime(showEntity.getShow_time()).movieResponseDto(MovieConverter.entityToDto(showEntity.getMovieEntity()))
                .theatreResponseDto(TheatreConverter.entityToDto(showEntity.getTheatreEntity())).build();
    }
    public ShowEntity dtoToEntity(ShowEntryDto showEntryDto)
    {
        return  ShowEntity.builder().show_date(showEntryDto.getShowdate()).show_time(showEntryDto.getShowtime()).build();

    }
}

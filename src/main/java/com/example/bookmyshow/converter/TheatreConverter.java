package com.example.bookmyshow.converter;

import com.example.bookmyshow.dto.entrydto.TheatreEntryDto;
import com.example.bookmyshow.dto.responsedto.TheatreResponseDto;
import com.example.bookmyshow.model.TheatreEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TheatreConverter {
    public static TheatreResponseDto entityToDto(TheatreEntity theatreEntity)
    {
        return TheatreResponseDto.builder().id(theatreEntity.getTheatre_id()).name(theatreEntity.getName()).address(theatreEntity.getAddress()).city(theatreEntity.getCity()).theatreType(theatreEntity.getTheatreType()).build();
    }
    public static TheatreEntity dtoToEntity(TheatreEntryDto theatreEntryDto)
    {
        return TheatreEntity.builder().name(theatreEntryDto.getName()).address(theatreEntryDto.getAddress()).city(theatreEntryDto.getCity()).theatreType(theatreEntryDto.getTheatreType()).build();

    }
}

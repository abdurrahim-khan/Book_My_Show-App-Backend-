package com.example.bookmyshow.service.implementation;

import com.example.bookmyshow.converter.TheatreConverter;
import com.example.bookmyshow.dto.entrydto.TheatreEntryDto;
import com.example.bookmyshow.dto.responsedto.TheatreResponseDto;
import com.example.bookmyshow.enums.SeatType;
import com.example.bookmyshow.model.TheatreEntity;
import com.example.bookmyshow.model.TheatreSeatEntity;
import com.example.bookmyshow.repository.TheatreRepository;
import com.example.bookmyshow.repository.TheatreSeatRepository;
import com.example.bookmyshow.service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class TheatreServiceImp implements TheatreService {
    @Autowired
    TheatreRepository theatreRepository;
    @Autowired
    TheatreSeatRepository theatreSeatRepository;
    @Override
    public void addTheatre(TheatreEntryDto theatreEntryDto) {
        TheatreEntity theatreEntity = TheatreConverter.dtoToEntity(theatreEntryDto);

        // adding theatreseatentity to theatreentity object as the former is also a field in latter's object
        List<TheatreSeatEntity> theatreSeatEntityList = new ArrayList<>();

        theatreSeatEntityList.add(createTheatreSeat("A101",300,SeatType.CLASSIC));
        theatreSeatEntityList.add(createTheatreSeat("A102",300,SeatType.CLASSIC));
        theatreSeatEntityList.add(createTheatreSeat("A103",300,SeatType.CLASSIC));
        theatreSeatEntityList.add(createTheatreSeat("B101",500,SeatType.PREMIUM));
        theatreSeatEntityList.add(createTheatreSeat("B102",500,SeatType.PREMIUM));
        theatreSeatEntityList.add(createTheatreSeat("B103",500,SeatType.PREMIUM));




        for(TheatreSeatEntity theatreSeat : theatreSeatEntityList)
        {
            theatreSeat.setTheatreEntity(theatreEntity);
            //theatreSeatRepository.save(theatreSeat);
        }
        theatreEntity.setListoftheatreseats(theatreSeatEntityList);
        theatreRepository.save(theatreEntity);
        theatreSeatRepository.saveAll(theatreSeatEntityList);
    }
    public TheatreSeatEntity createTheatreSeat(String seat_no, int rate, SeatType seatType)
    {
        return TheatreSeatEntity.builder().seat_no(seat_no).rate(rate).seatType(seatType).build();
    }

    @Override
    public TheatreResponseDto getTheatre(int id) {
        TheatreEntity theatreEntity = theatreRepository.findById(id).get();
        return TheatreConverter.entityToDto(theatreEntity);
    }
}

package com.example.bookmyshow.service.implementation;

import com.example.bookmyshow.converter.ShowConverter;
import com.example.bookmyshow.dto.entrydto.ShowEntryDto;
import com.example.bookmyshow.dto.responsedto.MovieResponseDto;
import com.example.bookmyshow.dto.responsedto.ShowResponseDto;
import com.example.bookmyshow.dto.responsedto.TheatreResponseDto;
import com.example.bookmyshow.model.*;
import com.example.bookmyshow.repository.MovieRepository;
import com.example.bookmyshow.repository.ShowRepository;
import com.example.bookmyshow.repository.ShowSeatsRepository;
import com.example.bookmyshow.repository.TheatreRepository;
import com.example.bookmyshow.service.ShowService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ShowServiceImp implements ShowService {
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    ShowSeatsRepository showSeatsRepository;
    @Autowired
    TheatreRepository theatreRepository;
    @Autowired
    ShowRepository showRepository;
    @Override
    public ShowResponseDto getShow(int showId) {
        ShowEntity showEntity = showRepository.findById(showId).get();
        return ShowConverter.entityToDto(showEntity);
    }

    @Override
    public void addShow(ShowEntryDto showEntryDto) {
        ShowEntity showEntity = ShowConverter.dtoToEntity(showEntryDto);
        //log.info(showEntity.getShow_date()+"");
//        showEntity.setShow_date(showEntryDto.getShowdate());
//        showEntity.setShow_time(showEntryDto.getShowtime());
        //log.info(showEntity.getShow_date()+"");
        //log.info(showEntryDto.getShowdate()+"");
        MovieResponseDto movieResponseDto = showEntryDto.getMovieResponseDto();
        TheatreResponseDto theatreResponseDto = showEntryDto.getTheatreResponseDto();

        MovieEntity movieEntity = movieRepository.findById(movieResponseDto.getId()).get();
        TheatreEntity theatreEntity = theatreRepository.findById(theatreResponseDto.getId()).get();

        showEntity.setTheatreEntity(theatreEntity);
        showEntity.setMovieEntity(movieEntity);

        List<ShowSeatsEntity> showSeatsEntityList = createShowSeatsEntityList(theatreEntity,showEntity);
        showEntity.setListofshowseats(showSeatsEntityList);
        showRepository.save(showEntity);
        showSeatsRepository.saveAll(showSeatsEntityList);

    }
    public List<ShowSeatsEntity> createShowSeatsEntityList(TheatreEntity theatreEntity, ShowEntity showEntity)
    {
        List<ShowSeatsEntity> showSeatsEntityList = new ArrayList<>();
        List<TheatreSeatEntity> theatreSeatEntityList = theatreEntity.getListoftheatreseats();

        for(TheatreSeatEntity theatreSeat : theatreSeatEntityList)
        {
            ShowSeatsEntity showSeatsEntity = ShowSeatsEntity.builder().seat_no(theatreSeat.getSeat_no())
                    .seatType(theatreSeat.getSeatType()).rate(theatreSeat.getRate()).booked(false).showEntity(showEntity).build();
            showSeatsEntityList.add(showSeatsEntity);
        }

        return  showSeatsEntityList;
    }
}

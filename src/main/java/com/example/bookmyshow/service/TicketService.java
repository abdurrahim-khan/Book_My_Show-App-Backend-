package com.example.bookmyshow.service;

import com.example.bookmyshow.dto.entrydto.BookingRequestDto;
import com.example.bookmyshow.dto.responsedto.TicketDto;

public interface TicketService {
    public TicketDto bookTicket(BookingRequestDto bookingRequestDto) throws Exception;
    public TicketDto getTicket(int id);
}

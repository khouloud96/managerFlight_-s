/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.microservices.TicketService.service;

import com.microservices.TicketService.dto.BookingDto;
import com.microservices.TicketService.entities.Booking;
import com.microservices.TicketService.repository.BookingRepository;
import com.microservices.TicketService.repository.PassengerRepository;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;
    
    @Autowired
    private PassengerRepository passengerRepository;
    
    public static BookingDto mapToDto(Booking booking) {
        if (booking != null) {
            return new BookingDto(
                    booking.getId(),
                    booking.getPassenger(),
                    booking.getNumFlight(),
                    booking.getSeats(),
                    booking.getTotPrice()
            );
        }
        return null;
    }
    
    public List<BookingDto> getBookings() {
        return this.bookingRepository.findAll()
                .stream()
                .map(BookingService::mapToDto)
                .collect(Collectors.toList());
    }

    public BookingDto getBookingById(Long id) {
        return bookingRepository.findById(id).map(BookingService::mapToDto).orElse(null);
    }
    
    public Booking getBookingByPassenger(String idPassenger) {
        return bookingRepository.findByPassenger(passengerRepository.findById(idPassenger).get());
    }
    
    /*public BigDecimal calculTotPrice(Booking booking){
        Long flight= booking.getNumFlight();
        BigDecimal unitPrice = flight.getLine().getUnitPrice();
        BigDecimal totPrice = BigDecimal.valueOf(booking.getSeats()).multiply(unitPrice);
        return totPrice;
    }*/
    
    public BookingDto addBooking(BookingDto bookingDto){
        Booking b = new Booking(
                        bookingDto.getId(),
                        bookingDto.getPassenger(),
                        bookingDto.getNumFlight(),
                        bookingDto.getSeats()
                );
        //b.setTotPrice(calculTotPrice(b));
        return mapToDto(
                bookingRepository.save(b)
        );
    }
    
     public void cancelBooking(Long id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Cannot find Booking with id " + id));

        bookingRepository.delete(booking);
    }
}

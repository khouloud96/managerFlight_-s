/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.microservices.TicketService.service;

import com.microservices.TicketService.dto.PassengerDtO;
import com.microservices.TicketService.entities.Passenger;
import com.microservices.TicketService.repository.PassengerRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public class PassengerService {
    @Autowired
    private PassengerRepository passengerRepository;
    
    
    public static PassengerDtO mapToDto(Passenger passenger) {
        if (passenger != null) {
            return new PassengerDtO(
                    passenger.getNumPassport(),
                    passenger.getFirstName(),
                    passenger.getLastName(),
                    passenger.getSexe(),
                    passenger.getEmail(),
                    passenger.getAge()
            );
        }
        return null;
    }
    
    public List<PassengerDtO> getPassengers() {
        return this.passengerRepository.findAll()
                .stream()
                .map(PassengerService::mapToDto)
                .collect(Collectors.toList());
    }

    public PassengerDtO getPassengerById(String id) {
        return passengerRepository.findById(id).map(PassengerService::mapToDto).orElse(null);
    }
    
    public PassengerDtO addPassenger(PassengerDtO passengerDtO){
        return mapToDto(
                passengerRepository.save(
                new Passenger(
                        passengerDtO.getNumPassport(),
                        passengerDtO.getFirstName(),
                        passengerDtO.getLastName(),
                        passengerDtO.getSexe(),
                        passengerDtO.getAge(),
                        passengerDtO.getEmail()
                )
            )
        );
    }
    
     public void deletePassenger(String id) {
        Passenger passenger = passengerRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Cannot find Passenger with id " + id));

        passengerRepository.delete(passenger);
    }
    
}

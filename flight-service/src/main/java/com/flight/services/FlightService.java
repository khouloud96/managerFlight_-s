package com.flight.services;

import com.flight.entities.Flight;
import com.flight.repository.FlightRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FlightService {
    @Autowired
    private FlightRepository flightRepository;
    
    public List<Flight> getFlights() {
        return flightRepository.findAll();
    }

    public Flight getFlightByNum(Long id) {
        return flightRepository.findById(id).get();
    }
    
    public Flight createFlight(Flight flight){
        return flightRepository.save(flight);
    }
    
     public void deleteFlight(Long id) {
        Flight flight = flightRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Cannot find Flight with id " + id));

        flightRepository.delete(flight);
    }
}


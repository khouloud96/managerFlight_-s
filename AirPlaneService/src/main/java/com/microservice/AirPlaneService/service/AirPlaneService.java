/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.microservice.AirPlaneService.service;

import com.microservice.AirPlaneService.entities.AirPlane;
import com.microservice.AirPlaneService.repository.AirPlaneRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AirPlaneService {
    @Autowired
    private AirPlaneRepository airPlaneRepository;
    
    public List<AirPlane> getAirPlanes() {
        return airPlaneRepository.findAll();
    }

    public AirPlane getAirPlaneByCode(String planeCode) {
        return airPlaneRepository.findById(planeCode).get();
    }
    
    public AirPlane createAirPlane(AirPlane airPlane){
        return airPlaneRepository.save(airPlane);
    }
    
     public void deleteAirPlane(String planeCode) {
        AirPlane airPlane = airPlaneRepository.findById(planeCode)
                .orElseThrow(() -> new IllegalStateException("Cannot find AirPlane with id " + planeCode));

        airPlaneRepository.delete(airPlane);
    }
}



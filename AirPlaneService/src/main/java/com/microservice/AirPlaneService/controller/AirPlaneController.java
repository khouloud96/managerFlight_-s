/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.microservice.AirPlaneService.controller;

import com.microservice.AirPlaneService.entities.AirPlane;
import com.microservice.AirPlaneService.service.AirPlaneService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DELL
 */
@RestController
@RequestMapping("/airplanes")
public class AirPlaneController {
    
    @Autowired
    private AirPlaneService airPlaneService;
    
    @GetMapping
    public List<AirPlane> getAirPlanes() {
        return airPlaneService.getAirPlanes();
    }

    @GetMapping("/{planeCode}")
    public AirPlane getAirPlaneByCode(@PathVariable String planeCode) {
        return airPlaneService.getAirPlaneByCode(planeCode);
    }

    @PostMapping
    public AirPlane createAirPlane(AirPlane airPlane) {
        return airPlaneService.createAirPlane(airPlane);
    }

    @DeleteMapping("/{planeCode}")
    public void deleteAirPlane(@PathVariable String planeCode) {
        airPlaneService.deleteAirPlane(planeCode);
    }
}


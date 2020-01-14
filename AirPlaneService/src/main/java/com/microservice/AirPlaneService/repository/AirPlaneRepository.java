/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.microservice.AirPlaneService.repository;

import com.microservice.AirPlaneService.entities.AirPlane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author DELL
 */
@Repository
public interface AirPlaneRepository extends JpaRepository<AirPlane, String> {

   
    
}

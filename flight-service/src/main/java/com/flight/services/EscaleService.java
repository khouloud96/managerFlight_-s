/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flight.services;

import com.flight.entities.Escale;

import com.flight.repository.EscaleRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author DELL
 */
public class EscaleService {
    @Autowired
    private EscaleRepository escaleRepository;
    public Escale getEscale (Long id)
     {
         return escaleRepository.findById(id).get();
     }
    public void deleteEscale(Long id){
       escaleRepository.deleteById(id);}
    
    public void updateEscaleAirport(Escale escale,String airport) {
        escale.setAirport(airport);
            escaleRepository.save(escale);
 }
     public void updateEscaleDepartureTime(Escale escale,String departureTime ) {
        escale.setDepartureTime(departureTime);
            escaleRepository.save(escale);
 }
     public void updateEscaleArrivalTime(Escale escale,String arrivalTime ) {
        escale.setArrivalTime(arrivalTime);
            escaleRepository.save(escale);
 }
    public List<Escale> retrieveEscale() {
       List<Escale> escales = escaleRepository.findAll();
            return escales;
 }
    public void saveEscale(Escale escale){
             escaleRepository.save(escale);
 }
}

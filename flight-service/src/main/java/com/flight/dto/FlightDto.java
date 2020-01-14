/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flight.dto;



import com.flight.entities.Escale;
import com.flight.entities.Line;
import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author DELL
 */
@Getter
@Setter
@NoArgsConstructor
public class FlightDto {
    private Date DepartureDate;
    
    private Date ArrivalDate;
    
    private Double duration;
    
    private List<String> airPlanes;
    
    private List<Line> lines;
    
    private List<Escale> escales;
    
    
}

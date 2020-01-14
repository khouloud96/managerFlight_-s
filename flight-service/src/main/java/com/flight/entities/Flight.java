/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flight.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author DELL
 */
@Data
@NoArgsConstructor
@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long flightNum;
    
    private Date DepartureDate;
    
    private Date ArrivalDate;
    
    private Double duration;
    
    
    private List<String> airPlanes;
    
    @OneToOne(mappedBy = "flight")
    @JsonIgnore
    private Line line;
    
    @OneToMany(mappedBy = "flight", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Escale> escales;
    
  
    
}

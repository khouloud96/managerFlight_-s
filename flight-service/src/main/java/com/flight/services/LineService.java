/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flight.services;

import com.flight.entities.Line;
import com.flight.repository.LineRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author DELL
 */
public class LineService {
    @Autowired
    private LineRepository LineRepository;
    public Line getLine (Long id)
     {
         return LineRepository.findById(id).get();
     }
    public void deleteLine(Long id){
      LineRepository.deleteById(id);}
    
    public void updateLine(Line line) {
            LineRepository.save(line);
 }
 
    public List<Line> retrieveLine() {
       List<Line> lines = LineRepository.findAll();
            return lines;
 }
    public void saveLine(Line line){
             LineRepository.save(line);
 }
}

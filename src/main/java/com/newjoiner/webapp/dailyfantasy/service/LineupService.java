package com.newjoiner.webapp.dailyfantasy.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.newjoiner.webapp.dailyfantasy.entity.Lineup; 
 
public interface LineupService {
 
	List<Lineup> findLineupsByUser(int userId); 
    
	ResponseEntity<Lineup> saveLineup(Lineup lineup);   
    
    ResponseEntity<Lineup> updateLineup(Lineup lineup);
    
    ResponseEntity<String> deleteLineup(int lineupId);
     
}
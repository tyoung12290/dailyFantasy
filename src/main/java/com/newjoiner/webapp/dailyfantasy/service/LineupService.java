package com.newjoiner.webapp.dailyfantasy.service;

import java.util.List;

import com.newjoiner.webapp.dailyfantasy.entity.Lineup; 
 
public interface LineupService {
 
	List<Lineup> findLineupsByUser(int userId); 
    
    void saveLineup(Lineup lineup);
    
    void deleteLineup(int lineupId);   
    
    void updateLineup(Lineup lineup);
     
}
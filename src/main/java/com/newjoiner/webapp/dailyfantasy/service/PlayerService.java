package com.newjoiner.webapp.dailyfantasy.service;

import com.newjoiner.webapp.dailyfantasy.entity.Player;

public interface PlayerService {
 
	Player findById(int id);
    
    void updatePlayer(Player player);
     
     
}
package com.newjoiner.webapp.dailyfantasy.service;


import org.springframework.stereotype.Service;

import com.newjoiner.webapp.dailyfantasy.entity.Player;

@Service("playerService")
public class PlayerServiceImpl implements PlayerService {

     
    @Override
	public Player findById(int id) {
        return findById(id);
    }
    
    @Override
    public void updatePlayer(Player player) {
    	updatePlayer(player);
    }
        
}

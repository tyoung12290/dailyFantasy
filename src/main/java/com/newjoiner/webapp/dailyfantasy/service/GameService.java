package com.newjoiner.webapp.dailyfantasy.service;

import java.util.List;
import java.util.Map;

import com.newjoiner.webapp.dailyfantasy.entity.Game;

public interface GameService {
 
	List<Game> findGames(Map<String,?> requestParams);
     
}
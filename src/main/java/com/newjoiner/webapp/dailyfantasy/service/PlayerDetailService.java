package com.newjoiner.webapp.dailyfantasy.service;

import java.util.List;
import java.util.Map;

import com.newjoiner.webapp.dailyfantasy.entity.PlayerDetail;
 
public interface PlayerDetailService {
 
	PlayerDetail findById(int id);
   
	List<PlayerDetail> findAllPlayers(Map<String,?> requestParams); 
     
}
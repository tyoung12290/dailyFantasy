package com.newjoiner.webapp.dailyfantasy.service;


import java.util.List;
import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.newjoiner.webapp.dailyfantasy.entity.Game;

@Service("GameService")
public class GameServiceImpl implements GameService {

     
    
    @Override public List<Game> findGames(Map<String, ?> requestParams) {
    	String url = "http://localhost:8080/SpringMVCCustom/game?date=";
    	url +=requestParams.get("date");
    	RestTemplate restTemplate = new RestTemplate();
    	ParameterizedTypeReference<List<Game>> responseType = new ParameterizedTypeReference<List<Game>>() {};
    	HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add("Accept", MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<Game> requestEntity = new HttpEntity<>(requestHeaders);

    	ResponseEntity<List<Game>> gameResponse = restTemplate.exchange(url,HttpMethod.GET,requestEntity,responseType);
    	
    	 return gameResponse.getBody();
    }

}

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

import com.newjoiner.webapp.dailyfantasy.entity.PlayerDetail;

@Service("playerDetailService")
public class PlayerDetailServiceImpl implements PlayerDetailService {
 
     
    @Override
	public PlayerDetail findById(int id) {
        return findById(id);
    }

    @Override public List<PlayerDetail> findAllPlayers(Map<String, ?> requestParams) {
    	String url = "http://localhost:8080/SpringMVCCustom/players?date=";
    	url +=requestParams.get("date");
    	RestTemplate restTemplate = new RestTemplate();
    	ParameterizedTypeReference<List<PlayerDetail>> responseType = new ParameterizedTypeReference<List<PlayerDetail>>() {};
    	HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add("Accept", MediaType.APPLICATION_JSON_VALUE);

        //request entity is created with request headers
        HttpEntity<PlayerDetail> requestEntity = new HttpEntity<>(requestHeaders);

    	ResponseEntity<List<PlayerDetail>> playerResponse = restTemplate.exchange(url,HttpMethod.GET,requestEntity,responseType);
    	 return playerResponse.getBody();
    }
}
    
       

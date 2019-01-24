package com.newjoiner.webapp.dailyfantasy.service;

import java.util.List;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.newjoiner.webapp.dailyfantasy.entity.Lineup;

@Service("lineupService")
public class LineupServiceImpl implements LineupService {

	final String dailyFantasyUrl = "http://localhost:8080/SpringMVCCustom/lineup";

	@Override
	public List<Lineup> findLineupsByUser(int userId) {
		String url = dailyFantasyUrl + "?userId=" + userId;
		RestTemplate restTemplate = new RestTemplate();
		ParameterizedTypeReference<List<Lineup>> responseType = new ParameterizedTypeReference<List<Lineup>>() {
		};
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.add("Accept", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<Lineup> requestEntity = new HttpEntity<>(requestHeaders);
		ResponseEntity<List<Lineup>> lineupResponse = restTemplate.exchange(url, HttpMethod.GET, requestEntity,
				responseType);
		return lineupResponse.getBody();
	}

	@Override
	public ResponseEntity<Lineup> saveLineup(Lineup lineup) {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.add("Accept", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<Lineup> requestEntity = new HttpEntity<>(lineup, requestHeaders);
		ResponseEntity<Lineup> lineupResponse = restTemplate.exchange(dailyFantasyUrl, HttpMethod.POST, requestEntity,
				Lineup.class);
		return lineupResponse;
	}

	@Override
	public ResponseEntity<Lineup> updateLineup(Lineup lineup) {
		String url = "http://localhost:8080/SpringMVCCustom/lineup";
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.add("Accept", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<Lineup> requestEntity = new HttpEntity<>(lineup, requestHeaders);
		ResponseEntity<Lineup> lineupResponse = restTemplate.exchange(dailyFantasyUrl, HttpMethod.PUT, requestEntity,
				Lineup.class);
		return lineupResponse;

	}

	@Override
	public ResponseEntity<String> deleteLineup(int lineupId) {
		String url = dailyFantasyUrl + "/" + lineupId;
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.add("Accept", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<Lineup> requestEntity = new HttpEntity<>(requestHeaders);
		ResponseEntity<String> lineupResponse = restTemplate.exchange(url, HttpMethod.DELETE, requestEntity,
				String.class);
		return lineupResponse;
	}

}

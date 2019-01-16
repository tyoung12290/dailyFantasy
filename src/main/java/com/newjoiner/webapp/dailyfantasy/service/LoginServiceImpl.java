package com.newjoiner.webapp.dailyfantasy.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.newjoiner.webapp.dailyfantasy.entity.User;


@Service("loginService")
public class LoginServiceImpl implements LoginService{
	
	
	@Override
	public User findByUser(User user) {
		String url = "http://localhost:8080/SpringMVCCustom/user";
		RestTemplate restTemplate = new RestTemplate();
		Map<String, String> request = new HashMap<String, String>();
		request.put("username",user.getUsername());
		ResponseEntity<User> userResponse = restTemplate.postForEntity(url, request,User.class);
        return userResponse.getBody();
    }
}



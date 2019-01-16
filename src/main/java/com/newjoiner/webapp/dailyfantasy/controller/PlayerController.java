package com.newjoiner.webapp.dailyfantasy.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.newjoiner.webapp.dailyfantasy.entity.PlayerDetail;
import com.newjoiner.webapp.dailyfantasy.service.PlayerDetailService;

@Controller
public class PlayerController {
	
	@Autowired
	//TODO add access modifier
	PlayerDetailService playerDetailService;
	
	
	@RequestMapping(value="/players", method = RequestMethod.GET)
	@ResponseBody
	public String listPlayers(@RequestParam Map<String,String> requestParams, Model model) throws JsonProcessingException {
		List<PlayerDetail> players = playerDetailService.findAllPlayers(requestParams);
		model.addAttribute("players",players);
		ObjectMapper mapper = new ObjectMapper();
		String playerJson = mapper.writeValueAsString(players);
		return playerJson;
	}
	
	
}

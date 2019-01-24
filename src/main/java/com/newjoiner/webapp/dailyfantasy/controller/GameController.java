package com.newjoiner.webapp.dailyfantasy.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newjoiner.webapp.dailyfantasy.entity.Game;
import com.newjoiner.webapp.dailyfantasy.service.GameService;

@Controller
public class GameController {
	
	@Autowired
	GameService gameService;
	
	
	@RequestMapping(value="/game", method = RequestMethod.GET)
	@ResponseBody
	public List<Game> getGames(@RequestParam Map<String,String> requestParams){
		return gameService.findGames(requestParams);
	}
	
	
}

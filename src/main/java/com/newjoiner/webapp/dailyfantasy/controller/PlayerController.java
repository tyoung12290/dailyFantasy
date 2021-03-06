package com.newjoiner.webapp.dailyfantasy.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newjoiner.webapp.dailyfantasy.entity.PlayerDetail;
import com.newjoiner.webapp.dailyfantasy.service.PlayerDetailService;

@Controller
public class PlayerController {
	
	@Autowired
	PlayerDetailService playerDetailService;
	
	
	@RequestMapping(value="/players", method = RequestMethod.GET)
	@ResponseBody
	public List<PlayerDetail> getPlayers(@RequestParam Map<String,String> requestParams){
		return playerDetailService.findAllPlayers(requestParams);
	}
	
	
}

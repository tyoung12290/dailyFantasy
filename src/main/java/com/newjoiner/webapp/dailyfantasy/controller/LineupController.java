package com.newjoiner.webapp.dailyfantasy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newjoiner.webapp.dailyfantasy.entity.Lineup;
import com.newjoiner.webapp.dailyfantasy.service.LineupService;
import com.newjoiner.webapp.dailyfantasy.service.PlayerService;

@Controller
public class LineupController {
	
	@Autowired
	//TODO add access modifier
	PlayerService playerService;
	
	@Autowired
	//TODO add access modifier
	LineupService lineupService;

	@RequestMapping(value="/lineup", method=RequestMethod.GET)
	@ResponseBody
	public List<Lineup> getLineups(@RequestParam(value="userId") int userId) {
		List<Lineup> lineups = lineupService.findLineupsByUser(userId);
		return lineups;
	}
	
	@RequestMapping(value="/lineup", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public String saveLineup(@RequestBody Lineup lineup) {
		System.out.println(lineup);
		lineupService.saveLineup(lineup);
		return  "{\"success\":200}";
	}
	
	@RequestMapping(value="/lineup/{lineupId}", method = RequestMethod.DELETE)
	@ResponseBody
	public String deleteLineup(@PathVariable int lineupId) {
		lineupService.deleteLineup(lineupId);
		return  "{\"success\":200}";
	}
	
	@RequestMapping(value="/lineup", method = RequestMethod.PUT)
	@ResponseBody
	public String updateLineup(@RequestBody Lineup lineup) {
		lineupService.updateLineup(lineup);
		return  "{\"success\":200}";
	}
}

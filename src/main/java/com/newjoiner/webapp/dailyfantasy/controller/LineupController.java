package com.newjoiner.webapp.dailyfantasy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newjoiner.webapp.dailyfantasy.entity.Lineup;
import com.newjoiner.webapp.dailyfantasy.service.LineupService;

@Controller
public class LineupController {
	
	
	@Autowired
	private LineupService lineupService;

	@RequestMapping(value="/lineup", method=RequestMethod.GET)
	@ResponseBody
	public List<Lineup> getLineups(@RequestParam(value="userId") int userId) {
		List<Lineup> lineups = lineupService.findLineupsByUser(userId);
		return lineups;
	}
	
	@RequestMapping(value="/lineup", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<Lineup> saveLineup(@RequestBody Lineup lineup) {
		ResponseEntity<Lineup> lineupResponse = lineupService.saveLineup(lineup);
		return  lineupResponse;
	}
	
	@RequestMapping(value="/lineup", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<Lineup> updateLineup(@RequestBody Lineup lineup) {
		ResponseEntity<Lineup> lineupResponse = lineupService.updateLineup(lineup);
		return  lineupResponse;
	}
	
	@RequestMapping(value="/lineup/{lineupId}", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<String> deleteLineup(@PathVariable int lineupId) {
		ResponseEntity<String> lineupResponse= lineupService.deleteLineup(lineupId);
		return  lineupResponse;
	}
}

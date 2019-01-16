package com.newjoiner.webapp.dailyfantasy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.newjoiner.webapp.dailyfantasy.entity.User;
import com.newjoiner.webapp.dailyfantasy.service.LoginService;


@Controller
public class loginController {

	
	//TODO add access modifier
	@Autowired
	LoginService loginService;

	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String loginScreen()  {
		System.out.println("he;;p");
		return "login";
	}
	
	@RequestMapping(value="/home", method = RequestMethod.POST)
	public String saveLineup(@ModelAttribute("user") User user, Model viewModel) {
	System.out.println(user);
	User userObj = loginService.findByUser(user);
	viewModel.addAttribute("userId", userObj.getId());
		return "home";
	}
}

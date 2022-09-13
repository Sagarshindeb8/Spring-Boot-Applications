package com.practice.controller;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyController {

	@RequestMapping(value="/about", method = RequestMethod.GET)
	public String about(Model model)
	{
		System.out.println("Inside about handler...");
		//Putting data in model
		model.addAttribute("name","Sagar Shinde");
		model.addAttribute("CurrentDate",new Date().toLocaleString());
		return "about";
	}
	
	//Iteration handler
	@GetMapping("/loop-example")
	public String iteratioonHandler(Model m)
	{
		//Create a list
		List<String> names = List.of("Ram","Sham","Om","Ganesh");
		m.addAttribute("names", names);
		return "iterate";
	}
	
	//Condition handler
	//Conditional statements in Thymeleaf
	@GetMapping("/condition")
	public String ConditionHandler(Model m) 
	{
		System.out.println("Conditional handler...");
		m.addAttribute("isActive", false);
		m.addAttribute("gender", "F");
		
		List<Integer> list = List.of(52);
		m.addAttribute("mylist", list);
		return "condition";
	}
	
	//Thymeleaf Templates - Including fragments
	@GetMapping("/service")
	public String serviceHandler(Model m)
	{
		m.addAttribute("title", "This is title from controller");
		m.addAttribute("subtitle", LocalDateTime.now().toString());
		return "service";
	}
	
	//For new about page
	@GetMapping("/newAbout")
	public String newAbout() 
	{
		return "aboutNew";
	}
	
	//For new about page
	@GetMapping("/contact")
	public String Contact() 
	{
		return "contact";
	}
}

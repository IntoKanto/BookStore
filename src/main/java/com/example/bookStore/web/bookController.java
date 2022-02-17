package com.example.bookStore.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class bookController {

	@RequestMapping("/index")
	public String viewBooks() {
		
		return "index";
	}
	
	
	
}

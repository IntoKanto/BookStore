package com.example.bookStore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.bookStore.BookRepository;



@Controller
public class bookController {
	@Autowired
	private BookRepository repository;

	@RequestMapping("/booklist")
	public String viewBooks(Model model) {
		model.addAttribute("books", repository.findAll());
		return "booklist";
	}
	
	
	
}

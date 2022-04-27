package com.example.bookStore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.bookStore.domain.Book;
import com.example.bookStore.domain.BookRepo;
import com.example.bookStore.domain.CategoryRepo;



@Controller
public class bookController {
	@Autowired
	private BookRepo brepo;
	@Autowired
	private CategoryRepo crepo;

	@RequestMapping(value= {"/", "/booklist"})
	public String viewBooks(Model model) {
		model.addAttribute("books", brepo.findAll());
		return "booklist";
	}
	
	@RequestMapping(value="/add")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categories", crepo.findAll());
		return "addbook";
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String save(Book book) {
		brepo.save(book);
		return "redirect:booklist";
	}
	
	@RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("id")Long bookId, Model model) {
		brepo.deleteById(bookId);
		return "redirect:../booklist";
	}
	
	 @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	    public String editBooks(@PathVariable("id")Long bookId, Model model) {
	    	model.addAttribute("book", brepo.findById(bookId));
	    	model.addAttribute("categories", crepo.findAll());
	        return "edit";
	    }     
	
	
	
	
	
}

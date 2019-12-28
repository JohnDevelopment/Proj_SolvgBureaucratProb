package com.lucrarecurs.lucrarecurs.java.controllers;

import com.lucrarecurs.lucrarecurs.java.entities.Book1;
import com.lucrarecurs.lucrarecurs.java.services.Books1Service;
import com.lucrarecurs.lucrarecurs.java.services.StudentBook1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/books1")
public class Books1Controller {
	
	@Autowired
	Books1Service books1Service;

	@Autowired
	StudentBook1Service studentBook1Service;

	@GetMapping(value = "")
	public String displayBooks1(Model model)
	{
		model.addAttribute("books1", books1Service.findAll());
		return "pages/books1";
	}

	@RequestMapping(value = "/students/{book_id:[a=0-9]+}")
	String displayBook1Students(@PathVariable String book_id, Model model) {
		Book1 book1 = books1Service.findById(Long.parseLong(book_id));
		model.addAttribute("book1", book1);
		model.addAttribute("book1Students", studentBook1Service.findAllByBookId(Long.parseLong(book_id)));
		return "fragments/book1-students";
	}
}

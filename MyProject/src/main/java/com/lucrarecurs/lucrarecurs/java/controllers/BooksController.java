package com.lucrarecurs.lucrarecurs.java.controllers;

import com.lucrarecurs.lucrarecurs.java.entities.Book;
import com.lucrarecurs.lucrarecurs.java.services.BooksService;
import com.lucrarecurs.lucrarecurs.java.services.StudentBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import com.lucrarecurs.lucrarecurs.java.entities.Student;

import java.util.Optional;

@Controller
@RequestMapping("/books")
public class BooksController {
	
	@Autowired
	BooksService booksService;

	@Autowired
	StudentBookService studentBookService;

	@GetMapping(value = "")
	public String displayBooks(Model model)
	{
		model.addAttribute("books", booksService.findAll());
		return "pages/books";
	}

	@RequestMapping(value = "/students/{book_id:[a=0-9]+}")
	String displayBookStudents(@PathVariable String book_id, Model model) {
		Book book = booksService.findById(Long.parseLong(book_id));
		model.addAttribute("book", book);
		model.addAttribute("bookStudents", studentBookService.findAllByBookId(Long.parseLong(book_id)));
		return "fragments/book-students";
	}
}

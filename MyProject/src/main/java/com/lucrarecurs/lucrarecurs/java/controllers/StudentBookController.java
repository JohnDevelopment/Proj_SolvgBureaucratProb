package com.lucrarecurs.lucrarecurs.java.controllers;

import com.lucrarecurs.lucrarecurs.java.entities.Book;
import com.lucrarecurs.lucrarecurs.java.entities.Student;
import com.lucrarecurs.lucrarecurs.java.entities.StudentBook;
import com.lucrarecurs.lucrarecurs.java.services.BooksService;
import com.lucrarecurs.lucrarecurs.java.services.StudentBookService;
import com.lucrarecurs.lucrarecurs.java.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/student-book")
public class StudentBookController {
	@Autowired
	StudentBookService studentBookService;

	@Autowired
	StudentService studentService;

	@Autowired
	BooksService booksService;


	@RequestMapping(value = "/statistics")
	String displayStatistics(Model model) {
		List<Student> students = studentService.findAll();
		List<Book> books = booksService.findAll();

		model.addAttribute("students", students);
		model.addAttribute("books", books);
		model.addAttribute("studentBookService", studentBookService);

		return "pages/statistics";
	}

	@GetMapping(value = "/assignbooktostudent")
	public String borrowBookGet(Model model) {
		model.addAttribute("newbookstudent", new StudentBook() );
		model.addAttribute("students", studentService.findAll());
		model.addAttribute("books", booksService.findAll());
		return "pages/borrow";
	}

	@PostMapping(value = "/assignbooktostudent")
	public String borrowBookPost(@ModelAttribute("newStudentBook") StudentBook studentBook, Errors errors, Model model) {
		studentBookService.addStudentBook(studentBook);
		model.addAttribute("newbookstudent", new StudentBook() );
		model.addAttribute("students", studentService.findAll());
		model.addAttribute("books", booksService.findAll());
		model.addAttribute("successMessage", String.format("Studentul %s a imprumutat cartea %s cu success", studentBook.getStudent().getName(), studentBook.getBook().getName()));

		return "pages/borrow";
	}
}

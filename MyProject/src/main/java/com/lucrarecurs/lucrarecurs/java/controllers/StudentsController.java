package com.lucrarecurs.lucrarecurs.java.controllers;

import com.lucrarecurs.lucrarecurs.java.entities.Book;
import com.lucrarecurs.lucrarecurs.java.entities.Student;
import com.lucrarecurs.lucrarecurs.java.services.BooksService;
import com.lucrarecurs.lucrarecurs.java.services.StudentBookService;
import com.lucrarecurs.lucrarecurs.java.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
public class StudentsController {

    @Autowired
    BooksService booksService;

    @Autowired
    StudentBookService studentBookService;

    @Autowired
    StudentService studentsService;


    @GetMapping(value = "")
    public String displayStudents(Model model)
    {
        model.addAttribute("students", studentsService.findAll());
        return "pages/students";
    }

    @RequestMapping(value = "/books/{student_id:[a=0-9]+}")
    String displayStudentBooks(@PathVariable String student_id, Model model) {
        Student student = studentsService.findById(Long.parseLong(student_id));
        model.addAttribute("student", student);
        model.addAttribute("bookStudents", studentBookService.findAllStudentId(Long.parseLong(student_id)));
        return "fragments/student-books";
    }


}

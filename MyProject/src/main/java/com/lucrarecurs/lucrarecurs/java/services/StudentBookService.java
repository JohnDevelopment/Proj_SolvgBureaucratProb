package com.lucrarecurs.lucrarecurs.java.services;

import com.lucrarecurs.lucrarecurs.java.entities.StudentBook;
import com.lucrarecurs.lucrarecurs.java.repositories.StudentBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


import javax.persistence.EntityManagerFactory;

@Service
public class StudentBookService
{
    @Autowired
    private StudentBookRepository studentBookRepository;

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    public List<StudentBook> findAllByBookId(Long bookId )
    {
        return StreamSupport.stream( studentBookRepository.findAllByBookId( bookId ).spliterator( ), false ).collect( Collectors.toList( ) );
    }

    public List<StudentBook> findAllStudentId(Long studentId )
    {
        return StreamSupport.stream( studentBookRepository.findAllByStudentId( studentId ).spliterator( ), false ).collect( Collectors.toList( ) );
    }

    public Long getAverageDuration(Long id_student, Long id_book) {
        Long val = studentBookRepository.getAverageDuration(id_student, id_book);
        return val != null ? val : 0;

    }

    public StudentBook addStudentBook(StudentBook studentBook) {
        return studentBookRepository.save(studentBook);
    }

}
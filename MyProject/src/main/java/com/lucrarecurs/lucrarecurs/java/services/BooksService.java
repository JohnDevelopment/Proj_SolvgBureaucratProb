package com.lucrarecurs.lucrarecurs.java.services;

import com.lucrarecurs.lucrarecurs.java.entities.Book;
import com.lucrarecurs.lucrarecurs.java.repositories.BooksRepository;
import com.lucrarecurs.lucrarecurs.java.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class BooksService
{

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private BooksRepository bookRepository;

    public Book findById(Long id )
    {
        return bookRepository.findById( id ).get();
    }

    public List<Book> findAll( )
    {
        return StreamSupport.stream( bookRepository.findAll( ).spliterator( ), false ).collect( Collectors.toList( ) );
    }

}
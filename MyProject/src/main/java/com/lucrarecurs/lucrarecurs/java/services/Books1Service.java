package com.lucrarecurs.lucrarecurs.java.services;

import com.lucrarecurs.lucrarecurs.java.entities.Book1;
import com.lucrarecurs.lucrarecurs.java.repositories.Books1Repository;
import com.lucrarecurs.lucrarecurs.java.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class Books1Service
{

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private Books1Repository book1Repository;

    public Book1 findById(Long id )
    {
        return book1Repository.findById( id ).get();
    }

    public List<Book1> findAll( )
    {
        return StreamSupport.stream( book1Repository.findAll( ).spliterator( ), false ).collect( Collectors.toList( ) );
    }

}
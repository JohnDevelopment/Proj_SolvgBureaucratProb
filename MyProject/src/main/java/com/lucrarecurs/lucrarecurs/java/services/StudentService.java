package com.lucrarecurs.lucrarecurs.java.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucrarecurs.lucrarecurs.java.entities.Student;
import com.lucrarecurs.lucrarecurs.java.repositories.StudentRepository;

@Service
public class StudentService
{

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> findAll( )
    {
        return StreamSupport.stream( studentRepository.findAll( ).spliterator( ), false ).collect( Collectors.toList( ) );
    }

    public Student findById(Long id )
    {
        return studentRepository.findById( id ).get();
    }

}
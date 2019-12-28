package com.lucrarecurs.lucrarecurs.java.services;

import com.lucrarecurs.lucrarecurs.java.entities.StudentBook1;
import com.lucrarecurs.lucrarecurs.java.repositories.StudentBook1Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManagerFactory;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class StudentBook1Service
{
    @Autowired
    private StudentBook1Repository studentBook1Repository;

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    public List<StudentBook1> findAllByBookId(Long bookId )
    {
        return StreamSupport.stream( studentBook1Repository.findAllByBook1Id( bookId ).spliterator( ), false ).collect( Collectors.toList( ) );
    }

    public List<StudentBook1> findAllStudentId(Long studentId )
    {
        return StreamSupport.stream( studentBook1Repository.findAllByStudentId( studentId ).spliterator( ), false ).collect( Collectors.toList( ) );
    }

    public Long getAverageDuration(Long id_student, Long id_book) {
        Long val = studentBook1Repository.getAverageDuration(id_student, id_book);
        return val != null ? val : 0;

    }

    public StudentBook1 addStudentBook(StudentBook1 studentBook) {
        return studentBook1Repository.save(studentBook);
    }

}
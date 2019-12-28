package com.lucrarecurs.lucrarecurs.java.repositories;


import com.lucrarecurs.lucrarecurs.java.entities.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepository extends CrudRepository<Student, Long>
{

}
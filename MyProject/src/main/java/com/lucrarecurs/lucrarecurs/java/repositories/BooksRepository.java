package com.lucrarecurs.lucrarecurs.java.repositories;

import com.lucrarecurs.lucrarecurs.java.entities.Book;
import com.lucrarecurs.lucrarecurs.java.entities.Student;
import com.lucrarecurs.lucrarecurs.java.entities.StudentBook;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksRepository extends CrudRepository<Book, Long> {

}
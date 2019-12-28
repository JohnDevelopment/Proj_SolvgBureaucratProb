package com.lucrarecurs.lucrarecurs.java.repositories;

import com.lucrarecurs.lucrarecurs.java.entities.Book1;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Books1Repository extends CrudRepository<Book1, Long> {

}
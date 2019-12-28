package com.lucrarecurs.lucrarecurs.java.repositories;


import com.lucrarecurs.lucrarecurs.java.entities.StudentBook;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentBookRepository extends CrudRepository<StudentBook, Long>
{
	public Iterable<StudentBook> findAllByBookId(Long bookId);
	public Iterable<StudentBook> findAllByStudentId(Long bookId);

	@Query("SELECT AVG(stb.duration) from StudentBook stb WHERE id_student=?1 AND id_book=?2")
	Long getAverageDuration(Long id_student, Long id_book);
}
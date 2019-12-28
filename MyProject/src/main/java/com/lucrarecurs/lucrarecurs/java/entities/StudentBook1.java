package com.lucrarecurs.lucrarecurs.java.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table (name = "STUDENTS_BOOKS")
@SequenceGenerator(name="seq", initialValue=10)
public class StudentBook1 implements Serializable{
	
	private static final long serialVersionUID = 2382928549416936934L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;


	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	@Column ( name = "DURATION", nullable = false, unique = false)
	private Integer duration;
	
	@ManyToOne
	@JoinColumn(name = "ID_STUDENT", referencedColumnName = "ID")
	@JsonBackReference
	private Student student;
	
	@ManyToOne
	@JoinColumn(name = "ID_BOOK", referencedColumnName = "ID")
	@JsonBackReference
	private Book1 book1;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Book1 getBook() {
		return book1;
	}

	public void setBook(Book1 book1) {
		this.book1 = book1;
	}

	@Override
	public String toString() {
		return "StudentBook [ duration=" + duration + ", student=" + student + ", book=" + book1 + "]";
	}
}

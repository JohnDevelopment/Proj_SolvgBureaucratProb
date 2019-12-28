package com.lucrarecurs.lucrarecurs.java.entities;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table (name = "STUDENTS_BOOKS")
@SequenceGenerator(name="seq", initialValue=10)
public class StudentBook implements Serializable{
	
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
	private Book book;

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

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return "StudentBook [ duration=" + duration + ", student=" + student + ", book=" + book + "]";
	}
}

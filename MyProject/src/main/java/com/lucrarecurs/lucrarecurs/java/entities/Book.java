package com.lucrarecurs.lucrarecurs.java.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;

@Entity
@Table ( name = "BOOKS" )
@SequenceGenerator(name="seq", initialValue=10)
public class Book implements Serializable {

	private static final long serialVersionUID = -2539687685678279338L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	
	@Column ( name = "BOOK_NAME", nullable = false, unique = false)
	private String name;

	@Column ( name = "AUTHOR", nullable = false, unique = false)
	private String author;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + "]" + ", by: " + author;
	}
}

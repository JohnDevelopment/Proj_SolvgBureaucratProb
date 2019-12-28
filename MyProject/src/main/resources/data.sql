INSERT INTO BOOKS ( id, book_name, author ) VALUES
	( 1, 'Power bank', 'DA' ),
	( 2, 'Casti audio Bluetooth ', 'DA'  ),
	( 3, 'Microphone mini', 'NU'  ),
	( 4, 'Mouse', 'NU'  ),
	( 5, 'Keyboard mini', 'DA'  ),
	( 6, 'Keyboard', 'DA'  ),
	( 7, 'REDUX Analogue watch', 'DA'  ),
	( 8, 'Micro sd card 32GB', 'DA'  );

	
INSERT INTO STUDENTS ( id, name ) VALUES
	( 1, 'Plotnicu Rodica' ),
	( 2, 'Vitcovsvii Igor' ),
	( 3, 'Vîrlan Ion' ),
	( 4, 'Zubenco Dimitri' );

drop table students_books;
create table students_books (id bigint not null identity, duration integer not null, id_book bigint, id_student bigint);

INSERT INTO STUDENTS_BOOKS ( id, duration, id_student, id_book ) VALUES
	( 1,  1,  1, 1 ),
	( 2,  2,  2, 2 ),
	( 3,  3,  3, 3 ),
	( 4,  4,  4, 4 ),
	( 5,  5,  1, 5 ),
	( 6,  1,  2, 6 ),
	( 7,  2,  3, 7 ),
	( 8,  3,  4, 8 ),
	( 9,  4,  1, 9 ),
	( 10, 5,  2, 1 ),
	( 11, 1, 3, 2 ),
	( 12, 2, 4, 3 ),
	( 13, 3, 1, 4 );


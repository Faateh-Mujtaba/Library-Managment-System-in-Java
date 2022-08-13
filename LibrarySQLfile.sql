
create database library;
use library;



create table author
(  author_id varchar (20) primary key, 
	author_name varchar(30)
	
);

create table book
(
	book_id varchar(20) primary key,
	book_name varchar(50),
	category varchar(20),
	no_of_books int,
    author_id varchar(20),
    foreign key(author_id) references author(author_id)
);
create table student
(
	student_id varchar(20) primary key,
	name varchar(30) not null
);

create table book_issue
(
	issue_id int primary key auto_increment,
	student_id varchar(20) not null,
	issue_date date,
	return_date date,
	book_id varchar(20),
	foreign key(student_id) references student(student_id),
    foreign key(book_id) references book(book_id)
);

create table admin
(
	admin_id varchar(20) primary key,
	password varchar(20)
);

insert into admin values('abbas','123');
insert into admin values('fateh','123');

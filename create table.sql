create database studDB;

use studDB;
Create table Student(student_id BIGINT(10) primary key,
first_name varchar(100) not null,
last_name varchar(100) not null,
address varchar(100) not null,
email varchar(100) not null
);
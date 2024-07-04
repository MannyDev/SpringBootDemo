package com.SpringFramework5.SpringBootDemo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.SpringFramework5.SpringBootDemo.model.Book;

public interface BookRepository extends CrudRepository<Book, Long>{}

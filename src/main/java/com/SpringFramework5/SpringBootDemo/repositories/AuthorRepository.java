package com.SpringFramework5.SpringBootDemo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.SpringFramework5.SpringBootDemo.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {}

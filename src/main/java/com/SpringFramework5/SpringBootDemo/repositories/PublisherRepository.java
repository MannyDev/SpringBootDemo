package com.SpringFramework5.SpringBootDemo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.SpringFramework5.SpringBootDemo.model.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {}

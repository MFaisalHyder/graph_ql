package com.company.poc.graphql.repository;

import com.company.poc.graphql.entities.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {

    List<Author> findByFirstName(String firstName);

}
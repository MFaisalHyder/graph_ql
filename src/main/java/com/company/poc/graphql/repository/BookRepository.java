package com.company.poc.graphql.repository;

import com.company.poc.graphql.entities.Book;
import com.company.poc.graphql.entities.Publisher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

    List<Book> findByAuthorID(Long authorID);

    List<Book> findByPublishers(Publisher publisher);

}
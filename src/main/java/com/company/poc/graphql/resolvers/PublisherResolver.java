package com.company.poc.graphql.resolvers;

import com.company.poc.graphql.entities.Book;
import com.company.poc.graphql.entities.Publisher;
import com.company.poc.graphql.repository.BookRepository;
import com.company.poc.graphql.repository.PublisherRepository;
import com.coxautodev.graphql.tools.GraphQLResolver;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PublisherResolver implements GraphQLResolver<Publisher> {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    public PublisherResolver(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooks(Publisher publisher) {
        return bookRepository.findByPublishers(publisherRepository.findById(publisher.getID()).orElse(new Publisher()));

    }

}
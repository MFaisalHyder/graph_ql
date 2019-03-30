package com.company.poc.graphql.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.company.poc.graphql.entities.Author;
import com.company.poc.graphql.entities.Book;
import com.company.poc.graphql.entities.Publisher;
import com.company.poc.graphql.exception.PublisherNotFoundException;
import com.company.poc.graphql.repository.AuthorRepository;
import com.company.poc.graphql.repository.BookRepository;
import com.company.poc.graphql.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Component
public class Query implements GraphQLQueryResolver {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    public Iterable<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    public long totalAuthorsCount() {
        return authorRepository.count();
    }

    public Iterable<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public long totalBooksCount() {
        return bookRepository.count();
    }

    public List<Author> findAuthorsByFirstName(String firstName) {
        List<Author> authorsWithGivenFirstName = new ArrayList<>();

        if (!StringUtils.isEmpty(firstName)) {
            authorsWithGivenFirstName = authorRepository.findByFirstName(firstName);
        }

        return authorsWithGivenFirstName;
    }

    public List<Publisher> findAllPublishers() {
        List<Publisher> allPublishers = new ArrayList<>();

        publisherRepository.findAll().forEach(allPublishers::add);

        return allPublishers;
    }

    public Publisher findPublisherByLicenseNumber(String licenseNumber) {
        Publisher publisher = null;

        if (!StringUtils.isEmpty(licenseNumber)) {
            publisher = publisherRepository.findByLicenseNumber(licenseNumber);

            if (publisher == null) {
                throw new PublisherNotFoundException("No registered publisher found against given License Number", "INVALID_LICENSE_NUMBER", licenseNumber);
            }
        }

        return publisher;
    }

    public Publisher findPublisherByContactNumber(String contactNumber) {
        Publisher publisher = null;

        if (!StringUtils.isEmpty(contactNumber)) {
            publisher = publisherRepository.findByContactNumber(contactNumber);

            if (publisher == null) {
                throw new PublisherNotFoundException("No registered publisher found against given Contact Number", "INVALID_CONTACT_NUMBER", contactNumber);
            }
        }

        return publisher;
    }

}
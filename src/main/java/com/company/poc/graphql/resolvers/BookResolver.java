package com.company.poc.graphql.resolvers;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.company.poc.graphql.entities.Author;
import com.company.poc.graphql.entities.Book;
import com.company.poc.graphql.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class BookResolver implements GraphQLResolver<Book> {

    @Autowired
    private AuthorRepository authorRepository;

    public BookResolver(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author getAuthor(Book book) {
        return authorRepository.findById(book.getAuthor().getID()).orElse(new Author());

    }

}
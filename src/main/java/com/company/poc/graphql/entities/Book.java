package com.company.poc.graphql.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;

    private String title;

    private String ISBN;

    private int pageCount;

    @ManyToOne
    @JoinColumn(name = "author_ID", nullable = false, updatable = false)
    private Author author;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE})
    @JoinTable(name = "book_publishers", joinColumns = {@JoinColumn(name = "Book_ID")}, inverseJoinColumns = {@JoinColumn(name = "Publisher_ID")})
    private Set<Publisher> publishers = new HashSet<>();

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setPublishers(Set<Publisher> publishers) {
        this.publishers = publishers;
    }

}
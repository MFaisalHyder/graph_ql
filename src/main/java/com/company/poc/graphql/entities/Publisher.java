package com.company.poc.graphql.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Publisher")
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;

    private String name;

    private String licenseNumber;

    private String address;

    private String contactNumber;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE}, mappedBy = "publishers")
    private Set<Book> books = new HashSet<>();

    public Publisher() {

    }

    public Publisher(long ID, String name, String licenseNumber, String address, String contactNumber, Set<Book> books) {
        this.ID = ID;
        this.name = name;
        this.licenseNumber = licenseNumber;
        this.address = address;
        this.contactNumber = contactNumber;
        this.books = books;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

}
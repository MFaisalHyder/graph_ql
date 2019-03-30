package com.company.poc.graphql.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Publisher")
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    private String name;

    private String licenseNumber;

    private String address;

    private String contactNumber;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE}, mappedBy = "publishers")
    private Set<Book> books = new HashSet<>();

    public Publisher() {

    }

    public Publisher(Long ID, String name, String licenseNumber, String address, String contactNumber) {
        this.ID = ID;
        this.name = name;
        this.licenseNumber = licenseNumber;
        this.address = address;
        this.contactNumber = contactNumber;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
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

  /*  @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Publisher)) return false;
        Publisher publisher = (Publisher) o;
        return getID() == publisher.getID() &&
                Objects.equals(getName(), publisher.getName()) &&
                Objects.equals(getLicenseNumber(), publisher.getLicenseNumber()) &&
                Objects.equals(getAddress(), publisher.getAddress()) &&
                Objects.equals(getContactNumber(), publisher.getContactNumber()) &&
                Objects.equals(getBooks(), publisher.getBooks());
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", licenseNumber='" + licenseNumber + '\'' +
                ", address='" + address + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", books=" + books +
                '}';
    }
*/
}
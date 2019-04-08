package com.company.poc.graphql.resolvers;

import com.company.poc.graphql.dto.PublisherDTO;
import com.company.poc.graphql.entities.Author;
import com.company.poc.graphql.entities.Book;
import com.company.poc.graphql.entities.Publisher;
import com.company.poc.graphql.exception.BookNotFoundException;
import com.company.poc.graphql.exception.PublisherNotFoundException;
import com.company.poc.graphql.repository.AuthorRepository;
import com.company.poc.graphql.repository.BookRepository;
import com.company.poc.graphql.repository.PublisherRepository;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class Mutation implements GraphQLMutationResolver {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    public Author addAuthor(String firstName, String middleName, String lastName, String residentialAddress,
                            String officeAddress, String mobileNumber, String telephoneNumber, String identityType,
                            String identityNumber, String gender) {

        Author author = new Author();
        author.setFirstName(firstName);
        author.setMiddleName(middleName);
        author.setLastName(lastName);
        author.setResidentialAddress(residentialAddress);
        author.setOfficeAddress(officeAddress);
        author.setMobileNumber(mobileNumber);
        author.setTelephoneNumber(telephoneNumber);
        author.setIdentityType(identityType);
        author.setIdentityNumber(identityNumber);
        author.setGender(gender);

        author = authorRepository.save(author);

        return author;
    }

    public Book publishBook(String title, String ISBN, Integer pageCount, Long authorID, List<String> publishersID) {

        Book book = new Book();
        book.setTitle(title);
        book.setISBN(ISBN);
        book.setPageCount(pageCount != null ? pageCount : 0);
        book.setAuthor(authorRepository.findById(authorID).orElse(null));

        if (!publishersID.isEmpty()) {
            Set<Publisher> publishers = new HashSet<>();

            for (String publisherID : publishersID) {
                publisherRepository.findById(Long.valueOf(publisherID)).ifPresent(publishers::add);

            }

            book.setPublishers(publishers);
        }

        book = bookRepository.save(book);

        return book;
    }

    public boolean removeBookRecord(Long ID) {
        System.out.print("ID of book to be removed is = " + ID);

        boolean bookRemoved = false;
        try {
            if (ID != null) {
                bookRepository.deleteById(ID);
                bookRemoved = true;

            }

        } catch (Exception exception) {
            System.out.print("Unable to delete book\n" + exception);

        }

        return bookRemoved;
    }

    public Book modifyBookPageCount(Long ID, Integer pageCount) {
        Book existingBook = null;

        if (ID != null) {
            existingBook = bookRepository.findById(ID).orElse(null);

            if (existingBook == null) {
                throw new BookNotFoundException("Book with given ID is unavailable", ID);
            }

            existingBook.setPageCount(pageCount);
            bookRepository.save(existingBook);

        }

        return existingBook;

    }

    public Publisher registerPublisher(String name, String licenseNumber, String address, String contactNumber) {
        Publisher publisher = new Publisher();
        publisher.setName(name);
        publisher.setLicenseNumber(licenseNumber);
        publisher.setAddress(address);
        publisher.setContactNumber(contactNumber);

        publisher = publisherRepository.save(publisher);

        return publisher;

    }

    public Publisher updatePublisherInfo(PublisherDTO publisher) {
        Publisher registerPublisher = null;
        if (publisher != null) {
            registerPublisher = publisherRepository.findByLicenseNumber(publisher.getLicenseNumber());

            if (registerPublisher == null) {
                throw new PublisherNotFoundException("No registered publisher found against given publisher License Number", "INVALID_LICENSE_NUMBER", String.valueOf(publisher.getID()));
            }

            registerPublisher.setName(!publisher.getName().isEmpty() ? publisher.getName() : registerPublisher.getName());
            registerPublisher.setLicenseNumber(!publisher.getLicenseNumber().isEmpty() ? publisher.getLicenseNumber() : registerPublisher.getLicenseNumber());
            registerPublisher.setAddress(publisher.getAddress() != null && !publisher.getAddress().isEmpty() ? publisher.getAddress() : registerPublisher.getAddress());
            registerPublisher.setContactNumber(publisher.getContactNumber() != null && !publisher.getContactNumber().isEmpty() ? publisher.getContactNumber() : registerPublisher.getContactNumber());

            publisherRepository.save(registerPublisher);
        }

        /*
        Publisher p = publisherRepository.findById(-6L).orElse(null);
        List<Book> allBooksByGivenAuthorID = bookRepository.findByAuthorID(1L);
        List<Book> allBooksByGivenPublisherID = bookRepository.findByPublishers(p);
        */

        return registerPublisher;
    }

    private Object addObjectInSet(Object object) {
        Set<Object> set = new HashSet<>();

        if (object != null) {
            set.add(object);
        }

        return set;
    }

}
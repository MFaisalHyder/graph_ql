package com.company.poc.graphql.repository;


import com.company.poc.graphql.entities.Publisher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepository extends CrudRepository<Publisher, Long> {

    Publisher findByLicenseNumber(String licenseNumber);

    Publisher findByContactNumber(String contactNumber);

}
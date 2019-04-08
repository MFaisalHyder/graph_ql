package com.company.poc.graphql.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;

    private String firstName;

    private String middleName;

    private String lastName;

    private String residentialAddress;

    private String officeAddress;

    private String mobileNumber;

    private String telephoneNumber;

    private String identityType;

    private String identityNumber;

    private String gender;

    public Author() {

    }

    public Author(long ID) {
        this.ID = ID;
    }

    public Author(long ID, String firstName, String middleName, String lastName, String residentialAddress, String officeAddress, String mobileNumber, String telephoneNumber, String identityType, String identityNumber, String gender) {
        this.ID = ID;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.residentialAddress = residentialAddress;
        this.officeAddress = officeAddress;
        this.mobileNumber = mobileNumber;
        this.telephoneNumber = telephoneNumber;
        this.identityType = identityType;
        this.identityNumber = identityNumber;
        this.gender = gender;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getResidentialAddress() {
        return residentialAddress;
    }

    public void setResidentialAddress(String residentialAddress) {
        this.residentialAddress = residentialAddress;
    }

    public String getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(String officeAddress) {
        this.officeAddress = officeAddress;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getIdentityType() {
        return identityType;
    }

    public void setIdentityType(String identityType) {
        this.identityType = identityType;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

}
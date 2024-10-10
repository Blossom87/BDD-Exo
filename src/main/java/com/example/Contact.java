package com.example;

import java.time.LocalDate;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Contact {

    private int id;
    private String lastName;
    private String firstName;
    private String pseudo;
    private String gender;
    private LocalDate birthDate;
    private String mail;
    private String adress;
    private String zipCode;
    private String personalPhone;
    private String professionalPhone;
    private String gitLinks;


    public Contact(String lastName, String firstName, String pseudo, String gender, LocalDate birthDate, String mail,
            String adress, String zipCode, String personalPhone, String professionalPhone, String gitLinks) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.pseudo = pseudo;
        this.gender = gender;
        this.birthDate = birthDate;
        this.mail = mail;
        this.adress = adress;
        this.zipCode = zipCode;
        this.personalPhone = personalPhone;
        this.professionalPhone = professionalPhone;
        this.gitLinks = gitLinks;
    }

    public Contact(int id, String lastName, String firstName, String pseudo, String gender, LocalDate birthDate,
            String mail, String adress, String zipCode, String personalPhone, String professionalPhone,
            String gitLinks) {

        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.pseudo = pseudo;
        this.gender = gender;
        this.birthDate = birthDate;
        this.mail = mail;
        this.adress = adress;
        this.zipCode = zipCode;
        this.personalPhone = personalPhone;
        this.professionalPhone = professionalPhone;
        this.gitLinks = gitLinks;
    }

    public Contact() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getPersonalPhone() {
        return personalPhone;
    }

    public void setPersonalPhone(String personalPhone) {
        this.personalPhone = personalPhone;
    }

    public String getProfessionalPhone() {
        return professionalPhone;
    }

    public void setProfessionalPhone(String professionalPhone) {
        this.professionalPhone = professionalPhone;
    }

    public String getGitLinks() {
        return gitLinks;
    }

    public void setGitLinks(String gitLinks) {
        this.gitLinks = gitLinks;
    }

    @Override
    public String toString() {
        return "\nContact [id=" + id + ", lastName=" + lastName + ", firstName=" + firstName + ", pseudo=" + pseudo + "]";
    }
}

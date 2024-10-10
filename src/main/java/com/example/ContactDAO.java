package com.example;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import com.example.Contact;
import com.example.DAO;

public class ContactDAO extends DAO<Contact> {

    public Contact find(int id) {
        Contact cont = new Contact();
        try {
            ResultSet result = this.connect
                    .createStatement(
                            ResultSet.TYPE_SCROLL_INSENSITIVE,
                            ResultSet.CONCUR_UPDATABLE)
                    .executeQuery(
                            "SELECT * FROM contact WHERE id = " + id);
            if (result.first())
                cont = new Contact(
                        result.getInt("id"),
                        result.getString("last_name"),
                        result.getString("first_name"),
                        result.getString("pseudo"),
                        result.getString("gender"),
                        LocalDate.parse(result.getString("birth_date")),
                        result.getString("email"),
                        result.getString("adress"),
                        result.getString("zipcode"),
                        result.getString("personal_phone_number"),
                        result.getString("professionnal_phone_number"),
                        result.getString("gitlink"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cont;

    }

    public Contact update(Contact updateContact, int id) {

        try {
            this.connect
                    .createStatement(
                            ResultSet.TYPE_SCROLL_INSENSITIVE,
                            ResultSet.CONCUR_UPDATABLE)
                    .executeUpdate(
                            "UPDATE public.contact SET first_name= '" + updateContact.getFirstName() + "'"
                                    + "WHERE id= " + id);

            updateContact = this.find(updateContact.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return updateContact;
    }

    public boolean delete(int id) {

        try {

            this.connect
                    .createStatement(
                            ResultSet.TYPE_SCROLL_INSENSITIVE,
                            ResultSet.CONCUR_UPDATABLE)
                    .executeUpdate(
                            "DELETE FROM contact WHERE id= " + id);

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Contact add(Contact newContact) {

        try {
            PreparedStatement stm = this.connect.prepareStatement(
                    "INSERT INTO public.contact (first_name,last_name,pseudo,gender,birth_date,email,adress,zipcode,personal_phone_number,professionnal_phone_number,gitlink) VALUES (?,?,?,?,?,?,?,?,?,?,?)");

            stm.setString(1, newContact.getFirstName());
            stm.setString(2, newContact.getLastName());
            stm.setString(3, newContact.getPseudo());
            stm.setString(4, newContact.getGender());
            stm.setDate(5, Date.valueOf(newContact.getBirthDate()));
            stm.setString(6, newContact.getMail());
            stm.setString(7, newContact.getAdress());
            stm.setString(8, newContact.getZipCode());
            stm.setString(9, newContact.getPersonalPhone());
            stm.setString(10, newContact.getProfessionalPhone());
            stm.setString(11, newContact.getGitLinks());

            System.err.println(stm.executeUpdate());

            stm.close();
            connect.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return newContact;
    }
}

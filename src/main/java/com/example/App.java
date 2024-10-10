package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import java.sql.SQLException;
import com.mysql.cj.xdevapi.PreparableStatement;
/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * 
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {

        /* ContactDAO contactDAO = new ContactDAO();

        System.out.println(contactDAO.find(2).toString()); */

        /* Contact newContact = new Contact("TestUpdate", "t", "t", "t", LocalDate.of(1998, 12, 1), "t", "t", "t", "t", "t", "t");
        ContactDAO updateContact = new ContactDAO();
        updateContact.update(newContact, 2).toString(); */

        /*ContactDAO deleteContact = new ContactDAO();
        deleteContact.delete(2);*/


        /* Contact newContact = new Contact("OMEGA", "TEST", "OMG", "ROBOT", LocalDate.of(1998, 9, 12), "T", "T", "T", "T", "T", "T");
        ContactDAO addContact = new ContactDAO();
        addContact.add(newContact).toString(); */

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
        
        /*List<Contact> contact = getContactById(10);
        System.out.println(contact);*/

        /*
         * List<Contact> contacts = getAllContact();
         * System.out.println(contacts);
         */

        // Suppression d'un utilisateur
        // deleteByFirstnameAndSurname("Bobby","Bob");

        // Récupération d'un contact par identifiant
        /*
         * Contact contact = getContactById(1);
         * deleteByFirstnameAndSurname(contact);
         */

        /* deleteById(6); */

        /* deleteByFirstnameAndSurname("Lidia", "Blavotski"); */

        /*
         * Contact newContact = new Contact("Test", "test", "Pseudo", "Male",
         * LocalDate.of(1998, 12, 1), "mail@mail.fr",
         * "87400", "0606060606", "0505055005", "gitlink.fr", "test");
         * addContact(newContact);
         */

        /*
         * Contact updatedContact = new Contact("TestC", "testc", "Pseudoc", "Male",
         * LocalDate.of(1998, 12, 1), "mail@mail.fr",
         * "87400", "0707070707", "0606060606", "gitlink.fr", "test");
         * updateContact(updatedContact, 10);
         */
    }


    public static List<Contact> getContactById(int id) {

        // TODO faire la fonction pour récupérer un contact
        ArrayList<Contact> sqlContact = new ArrayList<Contact>();

        try {
            
            String url = "jdbc:postgresql://localhost:5465/javac";
            
            Connection con = DriverManager.getConnection(url, "postgres", "B@nLgU4qz*9?D~3n83");
            
            PreparedStatement stm = con.prepareStatement("SELECT * FROM contact c WHERE id =?");
            
            stm.setInt(1, id);

            ResultSet result = stm.executeQuery();

            while (result.next()) {
                // récupération des valeurs des colonnes pour chaque contact
                int idC = result.getInt("id");
                String lastName = result.getString("last_name");
                String firstName = result.getString("first_name");
                String gender = result.getString("gender");
                LocalDate birthDate = LocalDate.parse(result.getString("birth_date"));
                String pseudo = result.getString("pseudo");
                String adress = result.getString("adress");
                String personalPhoneNumber = result.getString("personal_phone_number");
                String professionnalPhoneNumber = result.getString("professionnal_phone_number");
                String email = result.getString("email");
                String zipcode = result.getString("zipcode");
                String gitLink = result.getString("gitlink");

                Contact contact = new Contact(idC, lastName, firstName, pseudo, gender, birthDate, email, adress,
                        zipcode, personalPhoneNumber, professionnalPhoneNumber, gitLink);

                sqlContact.add(contact);

            }
            
            stm.close();
            result.close();
            con.close();
        } catch (Exception e) {
            System.err.println("Error");
            System.err.println(e.getMessage());
        }

        return sqlContact;

    }

    public static List<Contact> getAllContact() {

        ArrayList<Contact> sqlAllContact = new ArrayList<Contact>();

        try {
            // chaîne de connexion à la base de données
            String url = "jdbc:postgresql://localhost:5465/javac";
            // création d'un objet de la classe "Connection" en utilisant DriverManager
            Connection con = DriverManager.getConnection(url, "postgres", "B@nLgU4qz*9?D~3n83");
            // création d'un "Statement" (objet qui permet d'exéctuer une requête SQL)
            Statement stm = con.createStatement();
            // récupération de toutes les lignes de résultat (objet de la classe
            // "ResultSet")
            ResultSet result = stm.executeQuery("SELECT * FROM contact");
            // on passe en revue toutes les lignes

            while (result.next()) {
                // récupération des valeurs des colonnes pour chaque contact
                int id = result.getInt("id");
                String lastName = result.getString("last_name");
                String firstName = result.getString("first_name");
                String gender = result.getString("gender");
                LocalDate birthDate = LocalDate.parse(result.getString("birth_date"));
                String pseudo = result.getString("pseudo");
                String adress = result.getString("adress");
                String personalPhoneNumber = result.getString("personal_phone_number");
                String professionnalPhoneNumber = result.getString("professionnal_phone_number");
                String email = result.getString("email");
                String zipcode = result.getString("zipcode");
                String gitLink = result.getString("gitlink");

                Contact contact = new Contact(id, lastName, firstName, pseudo, gender, birthDate, email, adress,
                        zipcode, personalPhoneNumber, professionnalPhoneNumber, gitLink);

                sqlAllContact.add(contact);

                // affichage du résultat
                // System.out.format("[%d] %s %s\n", id, nom, prenom, genre, dateDeNaissance,
                // pseudo, adresse,
                // telPerso, telPro, mail, codePostale, gitLink);

                // Contact contact = new Contact(id, nom, prenom, genre, dateDeNaissance,
                // pseudo, adresse, telPerso, telPro, mail, codePostale, gitLink);
                // SqlallContacts.add(contact);
            }
            // fermeture des ressources
            stm.close();
            result.close();
            con.close();
        } catch (Exception e) {
            System.err.println("Error");
            System.err.println(e.getMessage());
        }

        return sqlAllContact;
    }

    public static boolean deleteByFirstnameAndSurname(String firstname, String lastname) {

        // TODO DELETE EN utilisant "firstname" et "surname"
        try {

            String url = "jdbc:postgresql://localhost:5465/javac";

            Connection con = DriverManager.getConnection(url, "postgres", "B@nLgU4qz*9?D~3n83");

            PreparedStatement stm = con.prepareStatement("DELETE FROM contact WHERE first_name=? and last_name=?");

            stm.setString(1, firstname);
            stm.setString(2, lastname);

            System.err.println(stm.executeUpdate());

            stm.close();
            con.close();

            return true;

        } catch (Exception e) {
            System.err.println("Error");
            System.err.println(e.getMessage());

        }
        return false;
    }

    public static boolean deleteByFirstnameAndSurname(Contact contact) {

        // TODO DELETE EN utilisant "firstname" et "surname"
        try {

            String url = "jdbc:postgresql://localhost:5465/javac";

            Connection con = DriverManager.getConnection(url, "postgres", "B@nLgU4qz*9?D~3n83");

            PreparedStatement stm = con.prepareStatement("DELETE FROM contact WHERE first_name=? and last_name=?");

            stm.setString(1, contact.getFirstName());
            stm.setString(2, contact.getLastName());

            System.err.println(stm.executeUpdate());

            stm.close();
            con.close();

            return true;

        } catch (Exception e) {
            System.err.println("Error");
            System.err.println(e.getMessage());

        }

        return false;
    }

    public static boolean deleteById(int id) {
        // TODO compléter la méthode
        try {

            String url = "jdbc:postgresql://localhost:5465/javac";

            Connection con = DriverManager.getConnection(url, "postgres", "B@nLgU4qz*9?D~3n83");

            PreparedStatement stm = con.prepareStatement("DELETE FROM contact WHERE id=?");

            stm.setInt(1, id);

            System.err.println(stm.executeUpdate());

            stm.close();
            con.close();

            return true;

        } catch (Exception e) {
            System.err.println("Error");
            System.err.println(e.getMessage());

        }
        return false;
    }

    public static Contact addContact(Contact contact) {
        // TODO compléter la méthode

        try {

            String url = "jdbc:postgresql://localhost:5465/javac";

            Connection con = DriverManager.getConnection(url, "postgres", "B@nLgU4qz*9?D~3n83");

            PreparedStatement stm = con.prepareStatement(
                    "INSERT INTO public.contact (first_name,last_name,pseudo,gender,birth_date,email,adress,zipcode,personal_phone_number,professionnal_phone_number,gitlink) VALUES (?,?,?,?,?,?,?,?,?,?,?)");

            stm.setString(1, contact.getFirstName());
            stm.setString(2, contact.getLastName());
            stm.setString(3, contact.getPseudo());
            stm.setString(4, contact.getGender());
            stm.setDate(5, Date.valueOf(contact.getBirthDate()));
            stm.setString(6, contact.getMail());
            stm.setString(7, contact.getAdress());
            stm.setString(8, contact.getZipCode());
            stm.setString(9, contact.getPersonalPhone());
            stm.setString(10, contact.getProfessionalPhone());
            stm.setString(11, contact.getGitLinks());

            System.err.println(stm.executeUpdate());

            stm.close();
            con.close();

        } catch (Exception e) {
            System.err.println("Error");
            System.err.println(e.getMessage());

        }

        return null;
    }

    public static Contact updateContact(Contact contact, int id) {
        // TODO compléter la méthode

        try {

            String url = "jdbc:postgresql://localhost:5465/javac";

            Connection con = DriverManager.getConnection(url, "postgres", "B@nLgU4qz*9?D~3n83");

            PreparedStatement stm = con.prepareStatement(
                    "UPDATE public.contact SET first_name=?, last_name=?, pseudo=?, gender=?, birth_date=?, email=?, adress=?, zipcode=?, personal_phone_number=?, professionnal_phone_number=?, gitlink=? WHERE id=?");

            stm.setString(1, contact.getFirstName());
            stm.setString(2, contact.getLastName());
            stm.setString(3, contact.getPseudo());
            stm.setString(4, contact.getGender());
            stm.setDate(5, Date.valueOf(contact.getBirthDate()));
            stm.setString(6, contact.getMail());
            stm.setString(7, contact.getAdress());
            stm.setString(8, contact.getZipCode());
            stm.setString(9, contact.getPersonalPhone());
            stm.setString(10, contact.getProfessionalPhone());
            stm.setString(11, contact.getGitLinks());

            stm.setInt(12, id);

            System.err.println(stm.executeUpdate());

            stm.close();
            con.close();

        } catch (Exception e) {
            System.err.println("Error");
            System.err.println(e.getMessage());

        }
        return null;
    }
}

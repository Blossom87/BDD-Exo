package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

       List<Contact> contacts = getAllContact();
       System.out.println(contacts);

       // Suppression d'un utilisateur
       deleteByFirstnameAndSurname("Bobby","Bob");

        // Récupération d'un contact par identifiant
        Contact contact = getContactById(1);

        deleteByFirstnameAndSurname(contact);
    }

    public static Contact getContactById(int id) {

        // TODO faire la fonction pour récupérer un contact
        return null;
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

    public static boolean deleteByFirstnameAndSurname(String firstname, String surname) {

        // TODO DELETE EN utilisant "firstname" et "surname"

        return false;
    }

    public static boolean deleteByFirstnameAndSurname(Contact contact) {

        // TODO DELETE EN utilisant "firstname" et "surname"
        return false;
    }

    public static boolean deleteById(int id) {
        // TODO compléter la méthode
        return false;
    }

    public static Contact addContact(Contact contact) {
        // TODO compléter la méthode
        return null;
    }

    public static Contact updateContact(Contact contact) {
        // TODO compléter la méthode
        return null;
    }
}

package com.example;

import java.sql.Connection;
import com.example.ConnectionPostgreSQL;


public abstract class DAO<T> {

    public Connection connect = ConnectionPostgreSQL.getInstance();

    public abstract T find(int id);

    public abstract T update(Contact updateContact, int id);

    public abstract T add(Contact newContact);
}

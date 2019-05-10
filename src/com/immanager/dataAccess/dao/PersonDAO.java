package com.immanager.dataAccess.dao;

import com.immanager.exception.AllPersonsException;
import com.immanager.exception.PersonByIDException;
import com.immanager.model.Person;

import java.util.ArrayList;

public interface PersonDAO {
    Person getPersonById(Integer id) throws PersonByIDException;
    ArrayList<Person> getAllPersons() throws AllPersonsException;
}

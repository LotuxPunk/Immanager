package com.immanager.business;

import com.immanager.dataAccess.PersonDbAccess;
import com.immanager.dataAccess.dao.PersonDAO;
import com.immanager.exception.AllPersonsException;
import com.immanager.model.Person;

import java.util.ArrayList;

public class PersonManager {
    private PersonDAO dataAccess;

    public PersonManager() {
        setDataAccess(new PersonDbAccess());
    }

    public ArrayList<Person> getAllPersons() throws AllPersonsException {
        return dataAccess.getAllPersons();
    }

    public void setDataAccess(PersonDAO dataAccess) {
        this.dataAccess = dataAccess;
    }
}

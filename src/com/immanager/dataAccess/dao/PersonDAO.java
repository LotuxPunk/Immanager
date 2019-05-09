package com.immanager.dataAccess.dao;

import com.immanager.exception.PersonByIDException;
import com.immanager.model.Person;

public interface PersonDAO {
    Person getPersonById(Integer id) throws PersonByIDException;
}

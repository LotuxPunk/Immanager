package com.immanager.dataAccess.dao;

import com.immanager.exception.ApartmentByIdException;
import com.immanager.model.Apartment;

public interface ApartmentDAO {
    Apartment getApartmentById(Integer id) throws ApartmentByIdException;
}

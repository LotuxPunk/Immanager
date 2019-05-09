package com.immanager.dataAccess.dao;

import com.immanager.exception.AllApartmentException;
import com.immanager.exception.ApartmentByIdException;
import com.immanager.model.Apartment;

import java.util.ArrayList;

public interface ApartmentDAO {
    Apartment getApartmentById(Integer id) throws ApartmentByIdException;
    ArrayList<Apartment> getAllApartments() throws AllApartmentException;
}

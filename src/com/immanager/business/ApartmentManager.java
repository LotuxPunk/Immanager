package com.immanager.business;

import com.immanager.dataAccess.ApartmentDbAccess;
import com.immanager.dataAccess.dao.ApartmentDAO;
import com.immanager.exception.AllApartmentException;
import com.immanager.model.Apartment;

import java.util.ArrayList;

public class ApartmentManager {
    private ApartmentDAO dataAccess;

    public ApartmentManager() {
        setDataAccess(new ApartmentDbAccess());
    }

    public ArrayList<Apartment> getAllApartments() throws AllApartmentException {
        return dataAccess.getAllApartments();
    }

    public void setDataAccess(ApartmentDAO dataAccess) {
        this.dataAccess = dataAccess;
    }
}

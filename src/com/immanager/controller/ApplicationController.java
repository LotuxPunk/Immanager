package com.immanager.controller;

import com.immanager.business.ApartmentManager;
import com.immanager.business.ContractManager;
import com.immanager.exception.AllApartmentException;
import com.immanager.exception.AllContractException;
import com.immanager.exception.ApartmentByIdException;
import com.immanager.exception.PersonByIDException;
import com.immanager.model.Apartment;
import com.immanager.model.Contract;

import java.util.ArrayList;

public class ApplicationController {
    private ContractManager contractManager;
    private ApartmentManager apartmentManager;

    public ApplicationController() {
        setContractManager(new ContractManager());
        setApartmentManager(new ApartmentManager());
    }

    public ArrayList<Contract> getAllContracts() throws AllContractException, ApartmentByIdException, PersonByIDException {
        return contractManager.getAllContracts();
    }

    public ArrayList<Apartment> getAllApartment() throws AllApartmentException {
        return apartmentManager.getAllApartments();
    }

    public void setContractManager(ContractManager contractManager) {
        this.contractManager = contractManager;
    }

    public void setApartmentManager(ApartmentManager apartmentManager) {
        this.apartmentManager = apartmentManager;
    }
}

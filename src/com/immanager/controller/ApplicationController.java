package com.immanager.controller;

import com.immanager.business.ApartmentManager;
import com.immanager.business.ContractManager;
import com.immanager.business.PersonManager;
import com.immanager.exception.*;
import com.immanager.model.Apartment;
import com.immanager.model.Contract;
import com.immanager.model.Person;

import java.util.ArrayList;

public class ApplicationController {
    private ContractManager contractManager;
    private ApartmentManager apartmentManager;
    private PersonManager personManager;

    public ApplicationController() {
        setContractManager(new ContractManager());
        setApartmentManager(new ApartmentManager());
        setPersonManager(new PersonManager());
    }

    public ArrayList<Contract> getAllContracts() throws AllContractException, ApartmentByIdException, PersonByIDException {
        return contractManager.getAllContracts();
    }

    public ArrayList<Apartment> getAllApartment() throws AllApartmentException {
        return apartmentManager.getAllApartments();
    }

    public ArrayList<Person> getAllPersons() throws AllPersonsException {
        return personManager.getAllPersons();
    }

    public void addContract(Contract contract) throws AddContractException {
        contractManager.addContract(contract);
    }

    public void setContractManager(ContractManager contractManager) {
        this.contractManager = contractManager;
    }

    public void setApartmentManager(ApartmentManager apartmentManager) {
        this.apartmentManager = apartmentManager;
    }

    public void setPersonManager(PersonManager personManager) {
        this.personManager = personManager;
    }
}

package com.immanager.controller;

import com.immanager.business.ApartmentManager;
import com.immanager.business.ContractManager;
import com.immanager.business.PersonManager;
import com.immanager.exception.*;
import com.immanager.model.*;

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

    public ArrayList<ContractResult> getAllContracts() throws AllContractException, ApartmentByIdException, PersonByIDException, AllRentException, AllPaymentException {
        return contractManager.getAllContracts();
    }

    public ArrayList<Apartment> getAllApartment() throws AllApartmentException {
        return apartmentManager.getAllApartments();
    }

    public ArrayList<Person> getAllPersons() throws AllPersonsException {
        return personManager.getAllPersons();
    }

    public void addContract(Contract contract, RentOwed rentOwed) throws AddContractException, AddRentOwedException {
        contractManager.addContract(contract, rentOwed);
    }

    public void updateContract(Contract contract) throws UpdateContractException {
        contractManager.updateContract(contract);
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

package com.immanager.dataAccess.dao;

import com.immanager.exception.AddContractException;
import com.immanager.exception.AllContractException;
import com.immanager.exception.ApartmentByIdException;
import com.immanager.exception.PersonByIDException;
import com.immanager.model.Contract;

import java.util.ArrayList;

public interface ContractDAO{
    ArrayList<Contract> getAllContracts() throws AllContractException, ApartmentByIdException, PersonByIDException;
    Integer addContract(Contract contract) throws AddContractException;
}

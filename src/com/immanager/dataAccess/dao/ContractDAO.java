package com.immanager.dataAccess.dao;

import com.immanager.exception.*;
import com.immanager.model.Contract;

import java.util.ArrayList;

public interface ContractDAO{
    ArrayList<Contract> getAllContracts() throws AllContractException, ApartmentByIdException, PersonByIDException;
    Integer addContract(Contract contract) throws AddContractException;
    void updateContract(Contract contract) throws UpdateContractException;
}

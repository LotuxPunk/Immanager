package com.immanager.business;

import com.immanager.dataAccess.ContractDbAccess;
import com.immanager.dataAccess.dao.ContractDAO;
import com.immanager.exception.AddContractException;
import com.immanager.exception.AllContractException;
import com.immanager.exception.ApartmentByIdException;
import com.immanager.exception.PersonByIDException;
import com.immanager.model.Contract;

import java.util.ArrayList;

public class ContractManager {
    private ContractDAO dataAccess;

    public ContractManager() {
        setDataAccess(new ContractDbAccess());
    }

    public ArrayList<Contract> getAllContracts() throws AllContractException, ApartmentByIdException, PersonByIDException {
        return dataAccess.getAllContracts();
    }

    public void addContract(Contract contract) throws AddContractException {
        dataAccess.addContract(contract);
    }

    public void setDataAccess(ContractDAO dataAccess) {
        this.dataAccess = dataAccess;
    }
}

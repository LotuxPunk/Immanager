package com.immanager.business;

import com.immanager.dataAccess.ContractDbAccess;
import com.immanager.dataAccess.dao.ContractDAO;
import com.immanager.exception.AllContractException;
import com.immanager.model.Contract;

import java.util.ArrayList;

public class ContractManager {
    private ContractDAO dataAccess;

    public ContractManager() {
        setDataAccess(new ContractDbAccess());
    }

    public ArrayList<Contract> getAllContracts() throws AllContractException {
        return dataAccess.getAllContracts();
    }

    public void setDataAccess(ContractDAO dataAccess) {
        this.dataAccess = dataAccess;
    }
}

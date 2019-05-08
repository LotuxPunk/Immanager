package com.immanager.controller;

import com.immanager.business.ContractManager;
import com.immanager.exception.AllContractException;
import com.immanager.model.Contract;

import java.util.ArrayList;

public class ApplicationController {
    private ContractManager manager;

    public ApplicationController() {
        setManager(new ContractManager());
    }

    public ArrayList<Contract> getAllContracts() throws AllContractException {
        return manager.getAllContracts();
    }

    public void setManager(ContractManager manager) {
        this.manager = manager;
    }
}

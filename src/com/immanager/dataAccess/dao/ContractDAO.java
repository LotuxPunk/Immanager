package com.immanager.dataAccess.dao;

import com.immanager.exception.AllContractException;
import com.immanager.model.Contract;

import java.util.ArrayList;

public interface ContractDAO{
    ArrayList<Contract> getAllContracts() throws AllContractException;
}

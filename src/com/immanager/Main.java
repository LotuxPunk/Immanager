package com.immanager;

import com.immanager.dataAccess.ContractDbAccess;
import com.immanager.exception.AllContractException;
import com.immanager.model.Contract;

import java.util.List;

public class Main {


    public static void main(String[] args){
        List<Contract> contractList = null;
        ContractDbAccess contractDbAccess = new ContractDbAccess();
        try {
            contractList = contractDbAccess.getAllContracts();
        } catch (AllContractException e) {
            e.printStackTrace();
        }
        System.out.println(contractList.toString());
        System.exit(0);
    }
}

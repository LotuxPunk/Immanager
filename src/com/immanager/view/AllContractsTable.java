package com.immanager.view;

import com.immanager.controller.ApplicationController;
import com.immanager.exception.AllContractException;
import com.immanager.model.Contract;

import javax.swing.*;
import java.util.List;

public class AllContractsTable extends JTable {
    private ApplicationController controller;

    public AllContractsTable(){
        setController(new ApplicationController());

        try{
            List<Contract> contractList = controller.getAllContracts();
            //TODO : Gérer le reste et l'affichage
        }
        catch (AllContractException e){
            //TODO : Gérer l'exception
            e.printStackTrace();
        }
    }

    public void setController(ApplicationController controller) {
        this.controller = controller;
    }
}

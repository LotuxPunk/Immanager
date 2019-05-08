package com.immanager.view.panel;

import com.immanager.controller.ApplicationController;
import com.immanager.exception.AllContractException;
import com.immanager.exception.ApartmentByIdException;
import com.immanager.exception.PersonByIDException;
import com.immanager.model.Contract;

import javax.swing.*;
import java.util.List;

public class AllContractsPanel extends JPanel {
    private ApplicationController controller;
    public AllContractsPanel() {
        super();
        setController(new ApplicationController());
        try {
            List<Contract> contracts =  controller.getAllContracts();
            Object[][] datas = new Object[][]{};
            contracts.forEach(contract ->{
                datas[contracts.indexOf(contract)] = contract.toArray();
            });
            JTable table = new JTable(datas, new Object[]{"JeNeSaisPas"});
            this.add(table);
        } catch (AllContractException | ApartmentByIdException | PersonByIDException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    public void setController(ApplicationController controller) {
        this.controller = controller;
    }
}

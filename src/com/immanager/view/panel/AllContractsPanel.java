package com.immanager.view.panel;

import com.immanager.controller.ApplicationController;
import com.immanager.exception.AllContractException;
import com.immanager.exception.ApartmentByIdException;
import com.immanager.exception.PersonByIDException;
import com.immanager.model.Contract;
import com.immanager.view.component.ContractsTable;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class AllContractsPanel extends JPanel {
    private ApplicationController controller;
    public AllContractsPanel() {
        super();
        setController(new ApplicationController());
        setLayout(new BorderLayout());
        try {
            List<Contract> contracts =  controller.getAllContracts();
            String[] col = {"Apartment", "FirstName", "LastName"};
            DefaultTableModel tableModel = new DefaultTableModel(col, 0);

            contracts.forEach(contract -> {
                String apartment = contract.getApartment().getName();
                String firstname = contract.getRenter().getFirstName();
                String lastname = contract.getRenter().getLastName();
                Object[] data = {apartment, firstname, lastname};
                tableModel.addRow(data);
            });

            ContractsTable contractsTable = new ContractsTable(tableModel);
            this.add(new JScrollPane(contractsTable));

        } catch (AllContractException | ApartmentByIdException | PersonByIDException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    public void setController(ApplicationController controller) {
        this.controller = controller;
    }
}

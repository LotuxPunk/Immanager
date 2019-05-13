package com.immanager.view.panel;

import com.immanager.controller.ApplicationController;
import com.immanager.exception.*;
import com.immanager.model.ContractResult;
import com.immanager.view.component.ContractsTable;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.List;

public class AllContractsPanel extends JPanel {
    private ApplicationController controller;
    private ListSelectionModel listSelect;
    private JFrame frame;
    public AllContractsPanel(JFrame frame) {
        super();
        this.frame = frame;
        setController(new ApplicationController());
        setLayout(new BorderLayout());
        try {
            ContractsTable contractsTable = new ContractsTable();
            List<ContractResult> contracts =  controller.getAllContracts();

            contracts.forEach(contract -> {
                String apartment = contract.getApartment().getName();
                String firstname = contract.getRenter().getFirstName();
                String lastname = contract.getRenter().getLastName();
                Object[] data = {apartment, firstname, lastname};
                contractsTable.addRow(data);
            });

            contractsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            listSelect = contractsTable.getSelectionModel();

            contractsTable.getSelectionModel().addListSelectionListener(e -> {
                int id = listSelect.getMinSelectionIndex();
                frame.getContentPane().removeAll();
                frame.setContentPane(new ContractPanel(contracts.get(id), frame));
                frame.setVisible(true);
            });

            this.add(new JScrollPane(contractsTable));

        } catch (AllContractException | ApartmentByIdException | PersonByIDException | AllPaymentException | AllRentException e) {
            JOptionPane.showMessageDialog(this, e.getClass().getName() +" "+e.getMessage());
        }
    }

    public void setController(ApplicationController controller) {
        this.controller = controller;
    }
}

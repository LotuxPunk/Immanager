package com.immanager.view.panel;

import com.immanager.model.ContractResult;
import com.immanager.view.listener.ContractsAction;

import javax.swing.*;
import java.awt.*;

public class ContractPanel extends JPanel {
    private JSplitPane splitPane;
    private JButton returnButton;
    private ContractResult contract;
    private JFrame frame;

    public ContractPanel(ContractResult contract, JFrame frame) {
        this.contract = contract;
        this.frame = frame;

        this.setLayout(new BorderLayout());

        PersonPanel personPanel = new PersonPanel(contract.getRenter());
        returnButton = new JButton("Retour");
        returnButton.addActionListener(new ContractsAction(frame));
        personPanel.add(returnButton);

        RentPanel rentPanel = new RentPanel(contract.getRentOweds(), contract.getPayments());
        splitPane= new JSplitPane(JSplitPane.VERTICAL_SPLIT, true, personPanel, rentPanel);

        this.add(splitPane);
    }
}

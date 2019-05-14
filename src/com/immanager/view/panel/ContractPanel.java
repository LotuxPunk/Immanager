package com.immanager.view.panel;

import com.immanager.model.ContractResult;
import com.immanager.view.listener.ContractsAction;
import com.immanager.view.listener.UpdateContractAction;

import javax.swing.*;
import java.awt.*;

public class ContractPanel extends JPanel {
    private JSplitPane splitPane;
    private JButton returnButton, modifyButton;

    public ContractPanel(ContractResult contract, JFrame frame) {
        this.setLayout(new BorderLayout());

        ContractInfo contractInfo = new ContractInfo(contract);
        returnButton = new JButton("Retour");
        returnButton.addActionListener(new ContractsAction(frame));
        contractInfo.add(returnButton);

        modifyButton = new JButton("Modifier");
        modifyButton.addActionListener(new UpdateContractAction(frame, contract));
        contractInfo.add(modifyButton);

        RentPanel rentPanel = new RentPanel(contract.getRentOweds(), contract.getPayments());
        splitPane= new JSplitPane(JSplitPane.VERTICAL_SPLIT, true, contractInfo, rentPanel);

        this.add(splitPane);
    }
}

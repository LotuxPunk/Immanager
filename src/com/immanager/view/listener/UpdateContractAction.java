package com.immanager.view.listener;

import com.immanager.model.ContractResult;
import com.immanager.view.panel.UpdateContractPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateContractAction implements ActionListener {
    private JFrame frame;
    private ContractResult contract;

    public UpdateContractAction(JFrame frame, ContractResult contract) {
        setFrame(frame);
        setContract(contract);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.getContentPane().removeAll();
        frame.setContentPane(new UpdateContractPanel(frame, contract));
        frame.setVisible(true);
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public void setContract(ContractResult contract) {
        this.contract = contract;
    }
}

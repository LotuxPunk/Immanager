package com.immanager.view.listener;

import com.immanager.view.panel.AllContractsPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContractsAction implements ActionListener {

    private JFrame frame;

    public ContractsAction(JFrame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.getContentPane().removeAll();
        frame.setContentPane(new AllContractsPanel());
        frame.setVisible(true);
    }
}

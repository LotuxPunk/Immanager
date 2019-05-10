package com.immanager.view.listener;

import com.immanager.view.panel.AddContractPanel;
import com.immanager.view.panel.FormContractPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddContractMenuAction implements ActionListener {
    private JFrame frame;

    public AddContractMenuAction(JFrame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.getContentPane().removeAll();
        frame.setContentPane(new AddContractPanel());
        frame.setVisible(true);
    }
}

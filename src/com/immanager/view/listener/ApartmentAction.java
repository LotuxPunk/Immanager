package com.immanager.view.listener;

import com.immanager.view.panel.AllApartmentPanel;
import com.immanager.view.panel.AllContractsPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ApartmentAction implements ActionListener {
    private JFrame frame;

    public ApartmentAction(JFrame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.getContentPane().removeAll();
        frame.setContentPane(new AllApartmentPanel());
        frame.setVisible(true);
    }
}

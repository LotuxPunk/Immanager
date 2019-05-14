package com.immanager.view.listener;

import com.immanager.view.panel.SearchRentByApartmentPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchPaymentsAction implements ActionListener {
    private JFrame frame;

    public SearchPaymentsAction(JFrame frame) {
        setFrame(frame);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.getContentPane().removeAll();
        frame.setContentPane(new SearchRentByApartmentPanel(frame));
        frame.setVisible(true);
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }
}

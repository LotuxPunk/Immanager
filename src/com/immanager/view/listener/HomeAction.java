package com.immanager.view.listener;

import com.immanager.view.panel.HomePanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeAction implements ActionListener {

    private JFrame frame;

    public HomeAction(JFrame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.getContentPane().removeAll();
        frame.setContentPane(new HomePanel(null));
        frame.setVisible(true);
    }
}

package com.immanager.view.listener;

import com.immanager.dataAccess.DataBaseConnection;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ExitAction implements ActionListener {
    private JFrame frame;

    public ExitAction(JFrame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            DataBaseConnection.getInstance().getConnection().close();
            System.exit(0);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
}

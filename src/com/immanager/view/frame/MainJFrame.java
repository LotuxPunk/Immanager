package com.immanager.view.frame;

import com.immanager.dataAccess.DataBaseConnection;
import com.immanager.view.menu.MenuBar;
import com.immanager.view.panel.HomePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

public class MainJFrame extends JFrame {
    public MainJFrame() throws HeadlessException {
        super("Immanager");
        setBounds(100,100, 500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setJMenuBar(new MenuBar(this));
        setContentPane(new HomePanel());
        setVisible(true);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                try {
                    DataBaseConnection.getInstance().getConnection().close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }
            }
        });
    }
}

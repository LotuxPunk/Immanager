package com.immanager.view.frame;

import com.immanager.view.panel.AllContractsPanel;

import javax.swing.*;
import java.awt.*;

public class MainJFrame extends JFrame {
    public MainJFrame() throws HeadlessException {
        super("Immanager");
        setBounds(100,100, 500,500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new AllContractsPanel());
    }
}

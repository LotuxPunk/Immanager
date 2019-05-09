package com.immanager.view.frame;

import com.immanager.view.menu.MenuBar;
import com.immanager.view.panel.HomePanel;

import javax.swing.*;
import java.awt.*;

public class MainJFrame extends JFrame {
    public MainJFrame() throws HeadlessException {
        super("Immanager");
        setBounds(100,100, 500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setJMenuBar(new MenuBar(this));
        setContentPane(new HomePanel());
        setVisible(true);
    }
}

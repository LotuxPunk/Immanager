package com.immanager.view.menu;

import com.immanager.view.listener.ContractsAction;
import com.immanager.view.listener.ExitAction;
import com.immanager.view.listener.HomeAction;

import javax.swing.*;

public class MenuBar extends JMenuBar {
    public MenuBar(JFrame frame) {

        //Home
        JMenu homeMenu = new JMenu("Home");

        JMenuItem homeItem = new JMenuItem("Home");
        homeMenu.add(homeItem);
        homeItem.addActionListener(new HomeAction(frame));

        JMenuItem exitItem = new JMenuItem("Exit");
        homeMenu.add(exitItem);
        exitItem.addActionListener(new ExitAction(frame));

        //Views
        JMenu viewMenu = new JMenu("Views");

        JMenuItem contractsViewItem = new JMenuItem("Contracts");
        viewMenu.add(contractsViewItem);
        contractsViewItem.addActionListener(new ContractsAction(frame));

        this.add(homeMenu);
        this.add(viewMenu);
    }
}

package com.immanager.view.menu;

import com.immanager.view.listener.*;

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

        JMenuItem apartmentsViewItem = new JMenuItem("Apartments");
        viewMenu.add(apartmentsViewItem);
        apartmentsViewItem.addActionListener(new ApartmentAction(frame));

        //Add
        JMenu addMenu = new JMenu("Add");

        JMenuItem addContractItem = new JMenuItem("Add contract");
        addMenu.add(addContractItem);
        addContractItem.addActionListener(new AddContractMenuAction(frame));

        this.add(homeMenu);
        this.add(viewMenu);
        this.add(addMenu);
    }
}

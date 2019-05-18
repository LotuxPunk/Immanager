package com.immanager.view.menu;

import com.immanager.view.listener.*;

import javax.swing.*;

public class MenuBar extends JMenuBar {
    public MenuBar(JFrame frame) {

        //Home
        JMenu homeMenu = new JMenu("Accueil");

        JMenuItem homeItem = new JMenuItem("Accueil");
        homeMenu.add(homeItem);
        homeItem.addActionListener(new HomeAction(frame));

        JMenuItem exitItem = new JMenuItem("Quitter");
        homeMenu.add(exitItem);
        exitItem.addActionListener(new ExitAction(frame));

        //Views
        JMenu viewMenu = new JMenu("Vues");

        JMenuItem contractsViewItem = new JMenuItem("Contrats");
        viewMenu.add(contractsViewItem);
        contractsViewItem.addActionListener(new ContractsAction(frame));

        JMenuItem apartmentsViewItem = new JMenuItem("Appartements");
        viewMenu.add(apartmentsViewItem);
        apartmentsViewItem.addActionListener(new ApartmentAction(frame));

        //Add
        JMenu addMenu = new JMenu("Ajout");

        JMenuItem addContractItem = new JMenuItem("Ajouter un contrat");
        addMenu.add(addContractItem);
        addContractItem.addActionListener(new AddContractMenuAction(frame));

        //Search
        JMenu searchMenu = new JMenu("Recherche");

        JMenuItem searchPayments = new JMenuItem("Rechercher les payements par appartement");
        searchMenu.add(searchPayments);
        searchPayments.addActionListener(new SearchPaymentsAction(frame));

        //Menus
        this.add(homeMenu);
        this.add(viewMenu);
        this.add(addMenu);
        this.add(searchMenu);
    }
}

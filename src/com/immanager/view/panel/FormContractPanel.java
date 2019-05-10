package com.immanager.view.panel;

import com.immanager.controller.ApplicationController;
import com.immanager.exception.AllApartmentException;
import com.immanager.exception.AllPersonsException;
import com.immanager.model.Apartment;
import com.immanager.model.Person;
import org.jdatepicker.JDatePicker;

import javax.swing.*;
import java.awt.*;

public class FormContractPanel extends JPanel {
    private JLabel lDateStart, lDateEnd, lWaranty, lCpasWaranty, lGuarantees, lRenter, lApartment, lRefRegistry;
    private JDatePicker dateStart, dateEnd;
    private JTextField waranty, refRegistry;
    private JList<Person> guaranteesJList;
    private JComboBox<Apartment> apartmentJComboBox;
    private JComboBox<Person> renter;
    private JCheckBox cpasWaranty;
    private ApplicationController controller;

    public FormContractPanel() {
        this.setController(new ApplicationController());
        this.setBounds(1, 1, 500,800);
        this.setLayout(new GridLayout(8,2, 5,5));

        Apartment[] apartments = null;
        Person[] people = null;

        try {
            apartments = controller.getAllApartment().toArray(new Apartment[]{});
            people = controller.getAllPersons().toArray(new Person[]{});
        } catch (AllApartmentException | AllPersonsException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        if (apartments != null && people != null){

            lDateStart = new JLabel("Date d'entrée");
            this.add(lDateStart);
            dateStart = new JDatePicker();
            this.add(dateStart);

            lDateEnd = new JLabel("Date de sortie");
            this.add(lDateEnd);
            dateEnd = new JDatePicker();
            this.add(dateEnd);

            lWaranty = new JLabel("Montant de la garantie");
            this.add(lWaranty);
            waranty = new JTextField();
            this.add(waranty);
            lCpasWaranty = new JLabel("Garantie par le CPAS ?");
            this.add(lCpasWaranty);
            cpasWaranty = new JCheckBox();
            this.add(cpasWaranty);

            lApartment = new JLabel("Appartement");
            this.add(lApartment);
            apartmentJComboBox = new JComboBox<>(apartments);
            this.add(apartmentJComboBox);

            lRefRegistry = new JLabel("Référence enregistrement contrat");
            this.add(lRefRegistry);
            refRegistry = new JTextField();
            this.add(refRegistry);

            lRenter = new JLabel("Locataire");
            this.add(lRenter);
            renter = new JComboBox<>(people);
            this.add(renter);

            lGuarantees = new JLabel("Avals");
            this.add(lGuarantees);
            guaranteesJList = new JList<>(people);
            guaranteesJList.setVisibleRowCount(2);
            JScrollPane scrollPane = new JScrollPane(guaranteesJList);
            this.add(scrollPane);
        }
    }

    public void setController(ApplicationController controller) {
        this.controller = controller;
    }

}

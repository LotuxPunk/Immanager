package com.immanager.view.panel;

import com.immanager.controller.ApplicationController;
import com.immanager.exception.AllApartmentException;
import com.immanager.model.Apartment;
import com.immanager.view.component.ApartmentTable;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AllApartmentPanel extends JPanel {

    private ApplicationController controller;

    public AllApartmentPanel() {
        super();
        setController(new ApplicationController());
        setLayout(new BorderLayout());
        try{
            ApartmentTable apartmentTable = new ApartmentTable();
            ArrayList<Apartment> apartments = controller.getAllApartment();

            for (Apartment apartment : apartments) {
                String name = apartment.getName();
                String city = apartment.getCity();
                String address = apartment.getAddress();
                int postalCode = apartment.getPostalCode();

                apartmentTable.addRow(name, city, address, postalCode);
            }

            this.add(new JScrollPane(apartmentTable));

        } catch (AllApartmentException e) {
            JOptionPane.showMessageDialog(this,e.getMessage());
        }

    }

    public void setController(ApplicationController controller) {
        this.controller = controller;
    }
}

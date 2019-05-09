package com.immanager.view.panel;

import com.immanager.controller.ApplicationController;
import com.immanager.exception.AllApartmentException;
import com.immanager.model.Apartment;
import com.immanager.view.component.ApartmentTable;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class AllApartmentPanel extends JPanel {

    private ApplicationController controller;

    public AllApartmentPanel() {
        super();
        setController(new ApplicationController());
        setLayout(new BorderLayout());
        try{
            ArrayList<Apartment> apartments = controller.getAllApartment();
            String[] col = {"Name", "City", "Address", "Postal Code"};
            DefaultTableModel tableModel = new DefaultTableModel(col, 0);

            for (Apartment apartment : apartments) {
                String name = apartment.getName();
                String city = apartment.getCity();
                String address = apartment.getAddress();
                int postalCode = apartment.getPostalCode();

                Object[] data = {name, city, address, postalCode};
                tableModel.addRow(data);
            }

            ApartmentTable table = new ApartmentTable(tableModel);
            this.add(new JScrollPane(table));

        } catch (AllApartmentException e) {
            JOptionPane.showMessageDialog(this,e.getMessage());
        }

    }

    public void setController(ApplicationController controller) {
        this.controller = controller;
    }
}

package com.immanager.view.component;

import com.immanager.model.Apartment;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class ApartmentTable extends JTable {

    public ApartmentTable() {
        String[] col = {"Nom", "Ville", "Adresse", "Code Postal"};
        DefaultTableModel tableModel = new DefaultTableModel(col, 0);

        setModel(tableModel);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    public void addRow(Object[] data){
        DefaultTableModel tableModel = (DefaultTableModel) this.getModel();
        tableModel.addRow(data);
    }

    public void addRow(String name, String city, String address, Integer postalCode){
        addRow(new Object[] {name, city, address, postalCode});
    }

    @Override
    public Class<?> getColumnClass(int column) {
        switch (column){
            case 3:
                return Integer.class;
            default:
                return String.class;
        }
    }
}

package com.immanager.view.component;

import com.immanager.model.Apartment;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ContractsTable extends JTable {

    public ContractsTable() {
        String[] col = {"Apartment", "FirstName", "LastName"};
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

    public void addRow(Apartment apartment, String firstname, String lastname){
        addRow(new Object[]{apartment, firstname, lastname});
    }
}

package com.immanager.view.component;

import com.immanager.model.Apartment;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class RentByApartmentTable extends JTable {
    public RentByApartmentTable() {
        String[] col = {"FirstName", "LastName", "Amount", "Date"};
        DefaultTableModel tableModel = new DefaultTableModel(col, 0);

        setModel(tableModel);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public void addRow(Object[] data){
        DefaultTableModel tableModel = (DefaultTableModel) this.getModel();
        tableModel.addRow(data);
    }

    public void addRow(String firstname, String lastname, Double amount, GregorianCalendar date){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        addRow(new Object[]{firstname, lastname, amount, dateFormat.format(date.getTime())});
    }
}

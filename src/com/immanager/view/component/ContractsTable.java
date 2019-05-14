package com.immanager.view.component;

import com.immanager.model.Apartment;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class ContractsTable extends JTable {

    public ContractsTable() {
        String[] col = {"Apartment", "FirstName", "LastName", "Address", "Ref registry", "Warranty", "Start Date", "End Date"};
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

    public void addRow(Apartment apartment, String firstname, String lastname, String address, String ref, Double warranty, GregorianCalendar startDate, GregorianCalendar endDate){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String endDateFormatted = null;

        if (endDate != null)
            endDateFormatted = dateFormat.format(endDate.getTime());

        addRow(new Object[]{apartment, firstname, lastname, address, ref, warranty, dateFormat.format(startDate.getTime()), endDateFormatted});
    }
}

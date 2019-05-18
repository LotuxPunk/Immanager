package com.immanager.view.component;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class RentTable extends JTable {
    public RentTable() {
        String[] col = {"Date", "Montant"};
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

    public void addRow(GregorianCalendar date, Double amount){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        addRow(new Object[]{dateFormat.format(date.getTime()), amount});
    }

    @Override
    public Class<?> getColumnClass(int column) {
        switch (column){
            case 1:
                return Double.class;
            default:
                return String.class;
        }

    }
}

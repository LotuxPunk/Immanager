package com.immanager.view.component;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

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
}

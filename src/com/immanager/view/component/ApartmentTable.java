package com.immanager.view.component;

import javax.swing.*;
import javax.swing.table.TableModel;

public class ApartmentTable extends JTable {

    public ApartmentTable(TableModel dm) {
        super(dm);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
}

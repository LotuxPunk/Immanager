package com.immanager.view.component;

import javax.swing.*;
import javax.swing.table.TableModel;

public class ContractsTable extends JTable {
    public ContractsTable(TableModel dm) {
        super(dm);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
}

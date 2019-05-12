package com.immanager.view.panel;

import com.immanager.model.Payment;
import com.immanager.model.RentOwed;
import com.immanager.view.component.RentTable;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class RentPanel extends JPanel {
    private ArrayList<RentOwed> rentOweds;
    private ArrayList<Payment> payments;
    private JSplitPane splitPane;

    public RentPanel(ArrayList<RentOwed> rentOweds, ArrayList<Payment> payments) {
        this.rentOweds = rentOweds;
        this.payments = payments;
        this.setLayout(new BorderLayout());

        RentTable rentsTable = new RentTable();
        RentTable paymentsTable = new RentTable();

        JScrollPane jScrollPanePayment = new JScrollPane(paymentsTable);
        JScrollPane jScrollPaneRent =  new JScrollPane(rentsTable);

        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, jScrollPaneRent, jScrollPanePayment);
        splitPane.setOneTouchExpandable(true);
        splitPane.setDividerLocation(.5);

        this.add(splitPane, BorderLayout.CENTER);
    }
}

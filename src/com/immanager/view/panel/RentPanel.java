package com.immanager.view.panel;

import com.immanager.model.Payment;
import com.immanager.model.ShowableRent;
import com.immanager.view.component.RentTable;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class RentPanel extends JPanel {
    private ArrayList<ShowableRent> rentOweds;
    private ArrayList<Payment> payments;
    private JSplitPane splitPane;

    public RentPanel(ArrayList<ShowableRent> rentOweds, ArrayList<Payment> payments) {
        setRentOweds(rentOweds);
        setPayments(payments);
        this.setLayout(new BorderLayout());

        RentTable rentsTable = new RentTable();
        RentTable paymentsTable = new RentTable();

        JScrollPane jScrollPanePayment = new JScrollPane(paymentsTable);
        JScrollPane jScrollPaneRent =  new JScrollPane(rentsTable);

        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, jScrollPaneRent, jScrollPanePayment);
        splitPane.setDividerLocation(.5);
        splitPane.setOneTouchExpandable(true);

        rentOweds.forEach(showableRent -> rentsTable.addRow(showableRent.getDate(), showableRent.getRent().getAmount().getTotal()));
        payments.forEach(payment -> paymentsTable.addRow(payment.getDate(), payment.getAmount()));

        this.add(splitPane, BorderLayout.CENTER);
    }

    public void setRentOweds(ArrayList<ShowableRent> rentOweds) {
        this.rentOweds = rentOweds;
    }

    public void setPayments(ArrayList<Payment> payments) {
        this.payments = payments;
    }
}

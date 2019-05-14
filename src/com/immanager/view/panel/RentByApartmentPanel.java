package com.immanager.view.panel;

import com.immanager.controller.ApplicationController;
import com.immanager.model.PaymentResult;
import com.immanager.view.component.RentByApartmentTable;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class RentByApartmentPanel extends JPanel {
    public RentByApartmentPanel(ArrayList<PaymentResult> payments) {
        setLayout(new BorderLayout());

        RentByApartmentTable rentTable = new RentByApartmentTable();
        payments.forEach(paymentResult -> rentTable.addRow(paymentResult.getPerson().getFirstName(), paymentResult.getPerson().getLastName(), paymentResult.getPayment().getAmount(), paymentResult.getPayment().getDate()));

        this.add(rentTable);
    }
}

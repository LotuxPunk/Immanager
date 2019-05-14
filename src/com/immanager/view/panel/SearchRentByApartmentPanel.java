package com.immanager.view.panel;

import com.immanager.controller.ApplicationController;
import com.immanager.exception.AllApartmentException;
import com.immanager.exception.AllPaymentFromApartmentException;
import com.immanager.model.Apartment;
import com.immanager.model.PaymentResult;
import org.jdatepicker.JDatePicker;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class SearchRentByApartmentPanel extends JPanel {
    private JDatePicker firstDate, lastDate;
    private JComboBox<Apartment> apartmentJComboBox;
    private JButton confirmButton;
    private JSplitPane splitPane;
    private ApplicationController controller;

    public SearchRentByApartmentPanel(JFrame frame) {
        setController(new ApplicationController());
        setLayout(new BorderLayout());

        try {
            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(1,4,5,5));

            apartmentJComboBox = new JComboBox<Apartment>(controller.getAllApartment().toArray(new Apartment[]{}));
            apartmentJComboBox.setToolTipText("Sélection de l'appartement");
            panel.add(apartmentJComboBox);

            firstDate = new JDatePicker();
            firstDate.setToolTipText("Date de début");
            panel.add(firstDate);

            lastDate = new JDatePicker();
            lastDate.setToolTipText("Date de fin");
            panel.add(lastDate);

            confirmButton = new JButton("Rechercher");
            panel.add(confirmButton);


            splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, true, panel, new JScrollPane(new RentByApartmentPanel(new ArrayList<PaymentResult>())));
            this.add(splitPane);

            confirmButton.addActionListener(e -> {
                StringBuilder error = new StringBuilder();

                if (firstDate.getFormattedTextField().getText().isEmpty() || lastDate.getFormattedTextField().getText().isEmpty())
                    error.append("Les dates sont obligatoires").append(System.getProperty("line.separator"));

                if (apartmentJComboBox.getSelectedItem() == null)
                    error.append("L'appartement est obligatoire").append(System.getProperty("line.separator"));

                if (!error.toString().isEmpty()){
                    JOptionPane.showMessageDialog(null, error.toString());
                }
                else{
                    try {
                        Apartment apartmentR = (Apartment) apartmentJComboBox.getSelectedItem();

                        ArrayList<PaymentResult> paymentResults = controller.getAllPaymentFromApartmentName(
                                (GregorianCalendar) firstDate.getModel().getValue(),
                                (GregorianCalendar) lastDate.getModel().getValue(),
                                apartmentR.getId()
                        );

                        splitPane.removeAll();
                        splitPane.setTopComponent(panel);
                        splitPane.setBottomComponent(new JScrollPane(new RentByApartmentPanel(paymentResults)));

                        frame.setVisible(true);

                    } catch (AllPaymentFromApartmentException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                }
            });

        } catch (AllApartmentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void setController(ApplicationController controller) {
        this.controller = controller;
    }
}

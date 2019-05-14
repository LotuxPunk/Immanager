package com.immanager.view.panel;

import com.immanager.controller.ApplicationController;
import com.immanager.exception.*;
import com.immanager.model.*;
import org.jdatepicker.JDatePicker;

import javax.swing.*;
import java.awt.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.GregorianCalendar;

public class FormContractPanel extends JPanel {
    private JLabel lDateStart, lDateEnd, lWaranty, lCpasWaranty, lGuarantees, lRenter, lApartment, lRefRegistry, lAmount, lCharge;
    private JDatePicker dateStart, dateEnd;
    private JTextField waranty, refRegistry, amount, charge;
    private JList<Person> guaranteesJList;
    private JComboBox<Apartment> apartmentJComboBox;
    private JComboBox<Person> renter;
    private JCheckBox cpasWaranty;
    private JButton confirmButton;
    private ApplicationController controller;
    private JFrame frame;

    public FormContractPanel(JFrame frame, ContractResult update) {
        this.frame = frame;
        this.setController(new ApplicationController());
        this.setBounds(1, 1, 500,800);
        this.setLayout(new GridLayout(11,2, 5,5));

        Apartment[] apartments = null;
        Person[] people = null;

        try {
            apartments = controller.getAllApartment().toArray(new Apartment[]{});
            people = controller.getAllPersons().toArray(new Person[]{});
        } catch (AllApartmentException | AllPersonsException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        if (apartments != null && people != null){

            lDateStart = new JLabel("Date d'entrée");
            this.add(lDateStart);
            dateStart = new JDatePicker();
            this.add(dateStart);

            lDateEnd = new JLabel("Date de sortie");
            this.add(lDateEnd);
            dateEnd = new JDatePicker();
            this.add(dateEnd);

            lWaranty = new JLabel("Montant de la garantie");
            this.add(lWaranty);
            waranty = new JTextField();
            this.add(waranty);
            lCpasWaranty = new JLabel("Garantie par le CPAS ?");
            this.add(lCpasWaranty);
            cpasWaranty = new JCheckBox();
            this.add(cpasWaranty);

            if (update == null) {
                lAmount = new JLabel("Montant du loyer");
                this.add(lAmount);
                amount = new JTextField();
                this.add(amount);
                lCharge = new JLabel("Montant des charges");
                this.add(lCharge);
                charge = new JTextField();
                this.add(charge);

                lGuarantees = new JLabel("Avals");
                this.add(lGuarantees);
                guaranteesJList = new JList<>(people);
                guaranteesJList.setVisibleRowCount(2);
                JScrollPane scrollPane = new JScrollPane(guaranteesJList);
                this.add(scrollPane);
            }

            lApartment = new JLabel("Appartement");
            this.add(lApartment);
            apartmentJComboBox = new JComboBox<>(apartments);
            this.add(apartmentJComboBox);

            lRefRegistry = new JLabel("Référence enregistrement contrat");
            this.add(lRefRegistry);
            refRegistry = new JTextField();
            this.add(refRegistry);

            lRenter = new JLabel("Locataire");
            this.add(lRenter);
            renter = new JComboBox<>(people);
            this.add(renter);

            confirmButton =  new JButton("Confirmer");
            this.add(confirmButton);

            if (update != null){
                if (update.getContract().getDateEnd() != null){
                    LocalDate endDate = new Date(update.getContract().getDateStart().getTimeInMillis()).toLocalDate();
                    dateStart.getModel().setDate(endDate.getDayOfMonth(), endDate.getMonth().getValue(), endDate.getYear());
                }

                waranty.setText(update.getContract().getWarranty().toString());
                cpasWaranty.setSelected(update.getContract().getCpasWarranty());

                apartmentJComboBox.setSelectedIndex(update.getContract().getApartmentID());

                refRegistry.setText(update.getContract().getRefEnregistrement());

                renter.setSelectedItem(update.getRenter());
            }

            confirmButton.addActionListener(e -> {
                StringBuilder error = new StringBuilder();
                if (guaranteesJList.getSelectedValuesList().size() > 2)
                    error.append("Maximum 2 avals").append(System.getProperty("line.separator"));

                if (!dateStart.getFormattedTextField().getText().isEmpty()){
                    GregorianCalendar dateS = (GregorianCalendar) dateStart.getModel().getValue();

                    if (!dateEnd.getFormattedTextField().getText().isEmpty()){
                        GregorianCalendar dateE = (GregorianCalendar) dateEnd.getModel().getValue();

                        if (dateS.compareTo(dateE) > 0)
                            error.append("La date d'entrée doit être inférieur a la date de sortie");
                    }
                }
                else{
                    error.append("La Date d'entrée est obligatoire").append(System.getProperty("line.separator"));
                }

                if (apartmentJComboBox.getSelectedItem() == null)
                    error.append("L'appartement est obligatoire").append(System.getProperty("line.separator"));

                if (update == null && (waranty.getText() == null || charge.getText() == null || amount.getText() == null))
                    error.append("Les montants de garantie/charge/loyer sont obligatoires").append(System.getProperty("line.separator"));

                if (update != null && waranty.getText() == null)
                    error.append("Le montants de garantie est obligatoire").append(System.getProperty("line.separator"));

                if (renter.getSelectedItem() != null){
                    if (guaranteesJList.getSelectedValuesList().contains(renter.getSelectedItem()))
                        error.append("Le locataire ne peut pas être un aval").append(System.getProperty("line.separator"));
                }
                else{
                    error.append("Le locataire est obligatoire").append(System.getProperty("line.separator"));
                }
                if (!error.toString().isEmpty()){
                    JOptionPane.showMessageDialog(null, error.toString());
                }
                else{
                    Integer guarantee1 = null, guarantee2 = null;
                    switch (guaranteesJList.getSelectedValuesList().size()){
                        case 2 :
                            guarantee2 = guaranteesJList.getSelectedValuesList().get(1).getId();
                        case 1 :
                            guarantee1 = guaranteesJList.getSelectedValuesList().get(0).getId();
                    }

                    Apartment apartmentR = (Apartment) apartmentJComboBox.getSelectedItem();
                    Integer apartmentID = apartmentR.getId();

                    Person renterR = (Person) renter.getSelectedItem();
                    Integer renterID = renterR.getId();

                    try{

                        if (update == null){
                            Contract contract = new Contract(
                                    null,
                                    (GregorianCalendar) dateStart.getModel().getValue(),
                                    (GregorianCalendar) dateEnd.getModel().getValue(),
                                    Double.valueOf(waranty.getText()),
                                    cpasWaranty.isSelected(),
                                    refRegistry.getText(),
                                    apartmentID,
                                    renterID,
                                    guarantee1,
                                    guarantee2
                            );

                            RentOwed firstRent = new RentOwed(
                                    Double.valueOf(amount.getText()),
                                    Double.valueOf(charge.getText()),
                                    (GregorianCalendar) dateStart.getModel().getValue()
                            );

                            controller.addContract(contract, firstRent);

                            getFrame().getContentPane().removeAll();
                            getFrame().setContentPane(new HomePanel("Contrat ajouté avec succès"));
                        }
                        else{
                            Contract contract = new Contract(
                                    update.getContract().getId(),
                                    update.getContract().getDateStart(),
                                    (GregorianCalendar) dateEnd.getModel().getValue(),
                                    Double.valueOf(waranty.getText()),
                                    cpasWaranty.isSelected(),
                                    refRegistry.getText(),
                                    apartmentID,
                                    renterID,
                                    update.getContract().getGuarantee1(),
                                    update.getContract().getGuarantee2()
                            );

                            controller.updateContract(contract);
                        }

                        getFrame().setVisible(true);
                    } catch (AddContractException | NumberFormatException | AddRentOwedException | UpdateContractException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                }
            });
        }
    }

    public void setController(ApplicationController controller) {
        this.controller = controller;
    }

    public JFrame getFrame() {
        return frame;
    }
}

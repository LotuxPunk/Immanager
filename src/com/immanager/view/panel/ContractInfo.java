package com.immanager.view.panel;

import com.immanager.model.ContractResult;
import com.immanager.model.Person;

import javax.swing.*;
import java.awt.*;

public class ContractInfo extends JPanel {
    private ContractResult contract;

    public ContractInfo(ContractResult contractResult) {
        setContract(contractResult);
        this.setLayout(new GridLayout(4,1,5,5));

        //TODO : Display info with grid layout
        this.add(new JLabel(contractResult.getRenter().getFirstName()+" "+contractResult.getRenter().getLastName()));
        this.add(new JLabel(contractResult.getRenter().getAddress()));
        this.add(new JLabel(contractResult.getRenter().getRegistry()));
        this.add(new JLabel("Situation du locataire : " + contractResult.getDifference() + "€"));

    }

    public void setContract(ContractResult contract) {
        this.contract = contract;
    }
}

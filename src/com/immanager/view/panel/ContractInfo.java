package com.immanager.view.panel;

import com.immanager.model.ContractResult;

import javax.swing.*;
import java.awt.*;

public class ContractInfo extends JPanel {

    public ContractInfo(ContractResult contractResult) {
        this.setLayout(new GridLayout(5,1,5,5));

        //TODO : Display info with grid layout
        this.add(new JLabel(contractResult.getRenter().getFirstName()+" "+contractResult.getRenter().getLastName()));
        this.add(new JLabel(contractResult.getRenter().getRegistry()));
        this.add(new JLabel("Situation du locataire : " + contractResult.getDifference() + "€"));
    }
}

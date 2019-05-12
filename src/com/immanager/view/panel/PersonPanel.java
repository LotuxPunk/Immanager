package com.immanager.view.panel;

import com.immanager.model.Person;

import javax.swing.*;
import java.awt.*;

public class PersonPanel extends JPanel {
    private Person person;

    public PersonPanel(Person person) {
        this.person = person;

        //TODO : Display info with grid layout
        this.add(new JLabel(person.getFirstName()+" "+person.getLastName()));
        this.add(new JLabel(person.getAddress()));
        this.add(new JLabel(person.getRegistry()));
        this.setLayout(new GridLayout(3,1));
    }
}

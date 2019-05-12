package com.immanager.view.panel;

import com.immanager.controller.ApplicationController;

import javax.swing.*;
import java.awt.*;

public class HomePanel extends JPanel {
    private ApplicationController controller;
    private JLabel lMessage;
    private JLabel lHomeMessage;

    public HomePanel(String message) {
        super();
        setController(new ApplicationController());

        lHomeMessage = new JLabel("Accueil - IMMANAGER");
        lHomeMessage.setHorizontalAlignment(JLabel.CENTER);
        this.add(lHomeMessage);

        if (message != null){
            lMessage = new JLabel(message);
            lMessage.setHorizontalAlignment(JLabel.CENTER);
            lMessage.setForeground(Color.BLUE);
            this.add(lMessage);
        }

    }

    public void setController(ApplicationController controller) {
        this.controller = controller;
    }
}

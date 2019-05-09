package com.immanager.view.panel;

import com.immanager.controller.ApplicationController;

import javax.swing.*;

public class HomePanel extends JPanel {
    private ApplicationController controller;

    public HomePanel() {
        super();
        setController(new ApplicationController());
    }

    public void setController(ApplicationController controller) {
        this.controller = controller;
    }
}

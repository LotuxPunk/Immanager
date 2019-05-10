package com.immanager.view.panel;

import javax.swing.*;
import java.awt.*;

public class AddContractPanel extends JPanel {
    private JButton confirmButon;
    public AddContractPanel() {
        this.setLayout(new FlowLayout());
        this.add(new FormContractPanel());
    }
}

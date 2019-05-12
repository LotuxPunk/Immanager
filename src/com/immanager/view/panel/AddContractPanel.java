package com.immanager.view.panel;

import javax.swing.*;
import java.awt.*;

public class AddContractPanel extends JPanel {
    private JFrame frame;

    public AddContractPanel(JFrame frame) {
        this.frame = frame;
        this.setLayout(new FlowLayout());
        this.add(new FormContractPanel(frame));
    }
}

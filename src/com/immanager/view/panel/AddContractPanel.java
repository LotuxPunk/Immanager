package com.immanager.view.panel;

import javax.swing.*;
import java.awt.*;

public class AddContractPanel extends JPanel {
    public AddContractPanel() {
        this.setLayout(new FlowLayout());
        this.add(new FormContractPanel());
    }
}

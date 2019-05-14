package com.immanager.view.panel;

import javax.swing.*;
import java.awt.*;

public class AddContractPanel extends JPanel {

    public AddContractPanel(JFrame frame) {
        this.setLayout(new BorderLayout());
        this.add(new FormContractPanel(frame, null));
    }
}

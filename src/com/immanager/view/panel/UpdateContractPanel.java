package com.immanager.view.panel;

import com.immanager.model.ContractResult;

import javax.swing.*;
import java.awt.*;

public class UpdateContractPanel extends JPanel {
    public UpdateContractPanel(JFrame frame, ContractResult contract) {
        this.setLayout(new BorderLayout());
        this.add(new FormContractPanel(frame, contract));
    }
}

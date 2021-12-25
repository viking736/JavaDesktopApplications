package com.company;

import javax.swing.*;
import java.awt.*;

public class WelcomePage {

    private JFrame frame = new JFrame();
    private JLabel welcomeLabel = new JLabel("Hello!!!");

    public WelcomePage(String userID) {

        welcomeLabel.setBounds(0, 0, 200, 25);
        welcomeLabel.setFont(new Font(null, Font.BOLD, 35));
        welcomeLabel.setText("Hello " + userID + "!");


        frame.add(welcomeLabel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 420);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


    }


}

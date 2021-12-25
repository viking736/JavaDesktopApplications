package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class LogInPage implements ActionListener {

    private JFrame frame = new JFrame();
    private JButton logInButton = new JButton("Login");
    private JButton resetButton = new JButton("Reset");
    private JTextField userIDField = new JTextField();
    private JPasswordField userPasswordField = new JPasswordField();
    private JLabel userIDLabel = new JLabel("userID: ");
    private JLabel userPasswordLabel = new JLabel("password: ");
    private JLabel messageLabel = new JLabel();


    private HashMap<String, String> logInInfo = new HashMap<>();

    public LogInPage(HashMap<String, String> logInInfo) {

        this.logInInfo = logInInfo;

        userIDLabel.setBounds(50, 100, 75, 75);
        userPasswordLabel.setBounds(50, 150, 75, 25);

        messageLabel.setBounds(125, 250, 350, 35);
        messageLabel.setFont(new Font(null, Font.BOLD, 25));

        userIDField.setBounds(125, 125, 200, 25);
        userPasswordField.setBounds(125, 150, 200, 25);

        logInButton.setBounds(125, 200, 100, 25);
        logInButton.setFocusable(false);
        logInButton.addActionListener(this);

        resetButton.setBounds(225, 200, 100, 25);
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);

        frame.add(userIDLabel);
        frame.add(userPasswordLabel);
        frame.add(messageLabel);
        frame.add(userIDField);
        frame.add(userPasswordField);
        frame.add(logInButton);
        frame.add(resetButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(450, 420));
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == resetButton) {

            userIDField.setText("");
            userPasswordField.setText("");

        }

        if (e.getSource() == logInButton) {

            String userID = userIDField.getText();
            String password = String.valueOf(userPasswordField.getPassword());

            if (logInInfo.containsKey(userID)) {

                if (logInInfo.get(userID).equals(password)) {

                    messageLabel.setForeground(Color.ORANGE);
                    messageLabel.setText("Logged in successfully!!!");

                    frame.dispose();

                    WelcomePage welcomePage = new WelcomePage(userID);

                } else {

                    messageLabel.setForeground(Color.RED);
                    messageLabel.setText("Invalid user password");

                }

            } else {

                messageLabel.setForeground(Color.RED);
                messageLabel.setText("invalid username/password");

            }

        }

    }
}

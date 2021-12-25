package com.company;

import javax.swing.*;

public class GameFrame extends JFrame {

    public GameFrame() {

        GamePanel panel = new GamePanel();

        this.add(panel);
        this.setTitle("Snake Game Java");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);


    }

}

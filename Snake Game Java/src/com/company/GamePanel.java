package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener {

    private static final int SCREEN_WIDTH = 600;
    private static final int SCREEN_HEIGHT = 600;
    private final int UNIT_SIZE = 25;
    private final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / UNIT_SIZE;
    private final int DELAY = 75;
    private final int[] x = new int[GAME_UNITS];
    private final int[] y = new int[GAME_UNITS];
    private int bodyParts = 6;
    private int applesEaten;
    private int appleX;
    private int appleY;
    private char direction = 'D';
    private boolean running = false;
    private Timer timer;
    private Random random;

    public GamePanel() {

        random = new Random();

        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.DARK_GRAY);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        startGame();

    }

    public void startGame() {

        newApple();
        running = true;

        timer = new Timer(DELAY, this);
        timer.start();

    }

    public void paintComponent(Graphics graphics) {

        super.paintComponent(graphics);
        draw(graphics);

    }

    public void draw(Graphics graphics) {

        if (running) {

            for (int i = 0; i < SCREEN_HEIGHT / UNIT_SIZE; i++) {

                graphics.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, SCREEN_HEIGHT);
                graphics.drawLine(0, i * UNIT_SIZE, SCREEN_WIDTH, i * UNIT_SIZE);

            }
            graphics.setColor(Color.ORANGE);
            graphics.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);

            for (int i = 0; i < bodyParts; i++) {

                if (i == 0) {

                    graphics.setColor(Color.BLUE);
                    graphics.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);

                } else {

                    graphics.setColor(Color.BLUE);
                    graphics.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);

                }

            }
            graphics.setColor(Color.RED);
            graphics.setFont(new Font("Arial", Font.PLAIN, 40));
            FontMetrics metrics = getFontMetrics(graphics.getFont());
            graphics.drawString("Score: " + applesEaten, (SCREEN_WIDTH - metrics.stringWidth("Score: " + applesEaten)) / 2,
                    graphics.getFont().getSize());

        } else {

            gameOver(graphics);

        }

    }

    public void newApple() {

        appleX = random.nextInt((int) (SCREEN_WIDTH / UNIT_SIZE)) * UNIT_SIZE;
        appleY = random.nextInt((int) (SCREEN_HEIGHT / UNIT_SIZE)) * UNIT_SIZE;


    }

    public void move() {

        for (int i = bodyParts; i > 0; i--) {

            x[i] = x[i - 1];
            y[i] = y[i - 1];

        }

        switch (direction) {
            case 'W':
                y[0] = y[0] - UNIT_SIZE;
                break;
            case 'S':
                y[0] = y[0] + UNIT_SIZE;
                break;
            case 'D':
                x[0] = x[0] + UNIT_SIZE;
                break;
            case 'A':
                x[0] = x[0] - UNIT_SIZE;
                break;
        }

    }

    public void checkApple() {

        if ((x[0] == appleX) && (y[0] == appleY)) {

            bodyParts++;
            applesEaten++;
            newApple();

        }

    }

    public void checkCollision() {

//        checking head collision with body
        for (int i = bodyParts; i > 0; i--) {

            if ((x[0] == x[i]) && (y[0] == y[i])) {

                running = false;

            }

        }
//        checking if head touches the left border
        if (x[0] < 0) {

            running = false;

        }
//        checking if head touches the left border
        if (x[0] > SCREEN_WIDTH) {

            running = false;

        }
//        checking if head touches top border
        if (y[0] < 0) {

            running = false;

        }

//        checking if head touches bottom border
        if (y[0] > SCREEN_HEIGHT) {

            running = false;

        }

        if (!running) {

            timer.stop();

        }


    }

    public void gameOver(Graphics graphics) {

//        Score
        graphics.setColor(Color.RED);
        graphics.setFont(new Font("Arial", Font.PLAIN, 40));
        FontMetrics metrics = getFontMetrics(graphics.getFont());
        graphics.drawString("Score: " + applesEaten, (SCREEN_WIDTH - metrics.stringWidth("Score: " + applesEaten)) / 2,
                graphics.getFont().getSize());


//        Game Over text
        graphics.setColor(Color.RED);
        graphics.setFont(new Font("Arial", Font.PLAIN, 80));
        FontMetrics metricsText = getFontMetrics(graphics.getFont());
        graphics.drawString("Game Over", (SCREEN_WIDTH - metricsText.stringWidth("Game Over")) / 2, SCREEN_HEIGHT / 2);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (running) {

            move();
            checkApple();
            checkCollision();

        }

        repaint();

    }

    public class MyKeyAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {

            switch (e.getKeyCode()) {

                case KeyEvent.VK_D:
                    if (direction != 'A') {

                        direction = 'D';

                    }
                    break;

                case KeyEvent.VK_A:
                    if (direction != 'D') {

                        direction = 'A';

                    }
                    break;

                case KeyEvent.VK_W:
                    if (direction != 'S') {

                        direction = 'W';

                    }
                    break;
                case KeyEvent.VK_S:
                    if (direction != 'W') {

                        direction = 'S';

                    }
                    break;

            }

        }
    }


}

package com.company;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Frame extends JFrame {

    public static Calendar calendar;

    private SimpleDateFormat timeFormat;
    private SimpleDateFormat dayFormat;
    private SimpleDateFormat dateFormat;
    private JLabel timeLabel;
    private JLabel dayLabel;
    private JLabel dateLabel;

    private String time;
    private String day;
    private String date;

    public Frame() throws InterruptedException {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Java Clock");
        this.setLayout(new FlowLayout());
        this.setSize(new Dimension(350, 200));
        this.setResizable(false);

        timeFormat = new SimpleDateFormat("hh:mm:ss a");
        dayFormat = new SimpleDateFormat("EEEE");
        dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Serif", Font.BOLD, 50));
        timeLabel.setForeground(Color.WHITE);
        timeLabel.setBackground(Color.BLACK);
        timeLabel.setOpaque(true);

        dayLabel = new JLabel();
        dayLabel.setFont(new Font("Times New Roman", Font.BOLD, 35));

        dateLabel = new JLabel();
        dateLabel.setFont(new Font("Times New Roman", Font.BOLD, 35));

        this.add(timeLabel);
        this.add(dayLabel);
        this.add(dateLabel);
        this.setVisible(true);
        this.setLocationRelativeTo(null);


        setTime();

    }

    private void setTime() throws InterruptedException {

        while(true) {
            time = timeFormat.format(calendar.getInstance().getTime());
            timeLabel.setText(time);

            day = dayFormat.format(calendar.getInstance().getTime());
            dayLabel.setText(day);

            date = dateFormat.format(calendar.getInstance().getTime());
            dateLabel.setText(date);

            Thread.sleep(1000);

        }
    }


}

/*
 * File         : WelcomePage.java (1 of 8)
 * Date         : 1 April 2024
 * Programmer   : Hakim Musyamril & Firdaus Denial
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WelcomePage extends JFrame implements ActionListener {
    JButton startButton;

    public WelcomePage() {
        // Create a title for the flight booking system
        setTitle("Welcome to Malaysia Airlines Flight Booking System");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create image icon logo
        ImageIcon logo = new ImageIcon("masLogo.png");
        JLabel logoLabel = new JLabel(logo);

        // Create a panel
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        add(panel);

        // Create Label
        JLabel label = new JLabel("Welcome to Malaysia Airlines", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(label, BorderLayout.CENTER);

        // Create Start Button
        startButton = new JButton("Start");
        startButton.addActionListener(this);
        panel.add(startButton, BorderLayout.SOUTH);
        startButton.setBounds(200, 250, 100, 40);
        panel.add(logoLabel);
        setVisible(true);

        // Register to a listener
        startButton.addActionListener(this);

        panel.add(startButton, BorderLayout.SOUTH);

        // Set the bounds of the startButton component within its parent container
        startButton.setBounds(200, 250, 100, 40);
        panel.add(logoLabel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            dispose();
            // Replace 'MovieSelection' with the appropriate class for Malaysia Airlines Flight Booking System
            new FlightSelection();
        }
    }

    public static void main(String[] args) {
        new WelcomePage();
    }
}
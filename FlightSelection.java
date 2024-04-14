/*
 * File         : FlightSelection.java (2 of 8)
 * Date         : 1 April 2024
 * Programmer   : Hakim Musyamril & Firdaus Denial
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FlightSelection extends JFrame implements ActionListener {
    JRadioButton international;
    JRadioButton domestic;
    JButton nextButton;

    public FlightSelection() {
        //create a title for the flight selection
        setTitle("Flight Selection");
        setSize(500, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        //create image icon logo
        ImageIcon logo = new ImageIcon("masLogo.png");
        JLabel logoLabel = new JLabel(logo);
        add(logoLabel);

        //create international and domestic flight selection
        international = new JRadioButton("International Flights");
        domestic = new JRadioButton("Domestic Flights");
        ButtonGroup group = new ButtonGroup();
        group.add(international);
        group.add(domestic);
        add(international);
        add(domestic);

        //create next button
        nextButton = new JButton("Next");
        nextButton.addActionListener(this);
        add(nextButton);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == nextButton) {
            if (international.isSelected()) {
                dispose();
                new InternationalRoutes();
            } else if (domestic.isSelected()) {
                dispose();
                new DomesticRoutes();
            }
        }
    }

    public static void main(String[] args) {
        new FlightSelection();
    }
}
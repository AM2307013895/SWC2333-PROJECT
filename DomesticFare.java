/*
 * File         : DomesticFare.java (8 of 8)
 * Date         : 1 April 2024
 * Programmer   : Hakim Musyamril & Firdaus Denial
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DomesticFare extends JFrame implements ActionListener {
    JComboBox<String> destination;
    JTextField adultFare, kidFare;
    JButton submitButton;
    String[] destinations = {"KUL - Kuala Lumpur",
                            "PEN - Penang",
                            "LGK - Langkawi",
                            "KCH - Kuching",
                            "SZB - Subang",
                            "BKI - Kota Kinabalu",
                            "SNA - Sandakan",
                            "TWU - Tawau",
                            "MYY - Miri",
                            "JHB - Johor Bahru"};
    int[] adultFares = {100, 80, 120, 150, 70, 130, 140, 160, 170, 90};
    int[] kidFares = {50, 40, 60, 75, 35, 65, 70, 80, 85, 45};

    public DomesticFare(String selectedAirport, int adultTickets, int kidTickets) {
        //create a title for the domestic fare
        setTitle("Domestic Fare - " + selectedAirport);
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        //create a label for the destination
        JLabel destinationLabel = new JLabel("Selected destination: " + selectedAirport);
        add(destinationLabel, BorderLayout.NORTH);

        //create a label for the adult and kid fares
        JLabel fareLabel = new JLabel("Fare:");
        add(fareLabel, BorderLayout.WEST);

        //create text fields for the adult and kid fares
        adultFare = new JTextField(Integer.toString(adultTickets * adultFares[getDestinationIndex(selectedAirport)]));
        kidFare = new JTextField(Integer.toString(kidTickets * kidFares[getDestinationIndex(selectedAirport)]));

        //set the text fields to be uneditable
        adultFare.setEditable(false);
        kidFare.setEditable(false);

        //create a panel to hold the text fields
        JPanel farePanel = new JPanel();
        farePanel.setLayout(new GridLayout(1, 2, 5, 5));
        farePanel.add(adultFare);
        farePanel.add(kidFare);
        add(farePanel, BorderLayout.CENTER);

        //create Submitbutton
        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);
        add(submitButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    public int getDestinationIndex(String destination) {
        for (int i = 0; i < destinations.length; i++) {
            if (destinations[i].equals(destination)) {
                return i;
            }
        }
        return -1;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            //close the DomesticFare window
            dispose();
        }
    }
}
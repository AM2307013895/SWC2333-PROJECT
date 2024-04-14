/*
 * File         : InternationalFare.java (5 of 8)
 * Date         : 1 April 2024
 * Programmer   : Hakim Musyamril & Firdaus Denial
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InternationalFare extends JFrame implements ActionListener {
    JComboBox<String> destination;
    JTextField adultFare, kidFare;
    JButton submitButton;
    String[] destinations = {"KUL - Kuala Lumpur International Airport",
                            "LHR - London Heathrow Airport",
                            "FRA - Frankfurt Airport",
                            "CDG - Charles de Gaulle Airport",
                            "NRT - Tokyo Narita International Airport",
                            "ICN - Incheon International Airport",
                            "PEK - Beijing Capital International Airport",
                            "SYD - Sydney Kingsford Smith Airport",
                            "MEL - Melbourne Airport",
                            "BKK - Suvarnabhumi Airport",
                            "HKG - Hong Kong International Airport",
                            "SIN - Singapore Changi Airport",
                            "AMS - Amsterdam Airport Schiphol",
                            "MAD - Adolfo Suárez Madrid-Barajas Airport",
                            "LAX - Los Angeles International Airport",
                            "JFK - John F. Kennedy International Airport"};
    int[] adultFares = {500, 1000, 800, 900, 1200, 1100, 1300, 1500, 1400, 1600, 1700, 1800, 1900, 2000, 2100, 2200};
    int[] kidFares = {250, 500, 400, 450, 600, 550, 650, 750, 700, 800, 850, 900, 950, 1000, 1050, 1100};

    public InternationalFare(String selectedAirport, int adultTickets, int kidTickets) {
        //create a title for the international fare
        setTitle("International Fare - " + selectedAirport);
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

        //create Submit button
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
            //close the InternationalFare window
            dispose();
        }
    }
}
/*
 * File         : InternationalRoutes.java (3 of 8)
 * Date         : 1 April 2024
 * Programmer   : Hakim Musyamril & Firdaus Denial
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InternationalRoutes extends JFrame implements ActionListener {
    JComboBox<String> airport;
    JButton submitButton;

    public InternationalRoutes() {
        //create a title for the international routes
        setTitle("International Routes");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        //create image icon logo
        ImageIcon logo = new ImageIcon("masLogo.png");
        JLabel logoLabel = new JLabel(logo);
        add(logoLabel, BorderLayout.NORTH);

        //create a combo box for the airport
        String[] airportCodes = {
            "KUL - Kuala Lumpur International Airport",
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
            "JFK - John F. Kennedy International Airport"
        };
        airport = new JComboBox<>(airportCodes);
        airport.addActionListener(this);
        add(airport, BorderLayout.CENTER);

        //create Submit button
        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);
        add(submitButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            String selectedAirport = (String) airport.getSelectedItem();
            JOptionPane.showMessageDialog(this, "You have selected: " + selectedAirport);

            //launch FlightTicket.java with the selected destination
            new FlightTicket(selectedAirport);
            dispose(); //close the InternationalRoutes window
        }
    }

    public static void main(String[] args) {
        new InternationalRoutes();
    }
}
/*
 * File         : DomesticRoutes.java (6 of 8)
 * Date         : 1 April 2024
 * Programmer   : Hakim Musyamril & Firdaus Denial
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DomesticRoutes extends JFrame implements ActionListener {
    JComboBox<String> airport;
    JButton submitButton;

    public DomesticRoutes() {
        //create a title for the domestic routes
        setTitle("Domestic Routes");
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
            "PEN - Penang International Airport",
            "LGK - Langkawi International Airport",
            "KCH - Kuching International Airport",
            "SZB - Sultan Abdul Aziz Shah Airport",
            "BKI - Kota Kinabalu International Airport",
            "SNA - Sandakan Airport",
            "TWU - Tawau Airport",
            "MYY - Miri Airport",
            "JHB - Johor Bahru International Airport"
        };
        airport = new JComboBox<>(airportCodes);
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

            //launch DomesticFlightTicket.java with the selected destination
            new DomesticFlightTicket(selectedAirport);
            dispose(); // Close the DomesticRoutes window
        }
    }

    public static void main(String[] args) {
        new DomesticRoutes();
    }
}
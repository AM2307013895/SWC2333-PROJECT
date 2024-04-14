/*
 * File         : DomesticFlightTicket.java (7 of 8)
 * Date         : 1 April 2024
 * Programmer   : Hakim Musyamril & Firdaus Denial
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DomesticFlightTicket extends JFrame implements ActionListener {
    JComboBox<String> adultTickets, kidTickets;
    JButton submitButton;
    String selectedAirport;

    public DomesticFlightTicket(String selectedAirport) {
        this.selectedAirport = selectedAirport;
        //create a title for the domestic flight ticket
        setTitle("Domestic Flight Ticket - " + selectedAirport);
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        //create a label for the number of adults and kids
        JLabel adultLabel = new JLabel("Number of adults (1-10):");
        JLabel kidLabel = new JLabel("Number of kids (0-10):");

        //create combo boxes for the number of adults and kids
        String[] ticketNumbers = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        adultTickets = new JComboBox<>(ticketNumbers);
        kidTickets = new JComboBox<>(ticketNumbers);

        //create Submit button
        submitButton = new JButton("Submit");

        //add components to the frame
        add(adultLabel);
        add(adultTickets);
        add(kidLabel);
        add(kidTickets);
        add(submitButton);

        //add action listener to the submit button
        submitButton.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            int adultTicketsSelected = adultTickets.getSelectedIndex();
            int kidTicketsSelected = kidTickets.getSelectedIndex();

            String message = "You have selected:\n";
            message += adultTicketsSelected + " adult ticket(s)\n";
            message += kidTicketsSelected + " kid ticket(s)\n";
            message += "for the destination: " + selectedAirport;

            JOptionPane.showMessageDialog(this, message);

            //launch DomesticFare.java with the selected destination
            new DomesticFare(selectedAirport, adultTicketsSelected, kidTicketsSelected);
            dispose(); //close the DomesticFlightTicket window
        }
    }
}
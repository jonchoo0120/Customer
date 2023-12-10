package com.mycompany.customer;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class CustomerPaymentSuccessGUI {
    private String username, userID, contact;
    public void showOrderSuccessMessage(String username, String userID, String contact, String orderId) {
        this.username = username;
        this.userID = userID;
        this.contact = contact;
        
        JFrame successFrame = new JFrame("Payment Successful");
        successFrame.setSize(400, 200);
        successFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        successFrame.setLocationRelativeTo(null);

        JLabel successLabel = new JLabel("Payment Successfully! Your Order ID is " + orderId);
        successLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
        successLabel.setHorizontalAlignment(SwingConstants.CENTER);
        successFrame.add(successLabel, BorderLayout.CENTER);

        JButton backButton = new JButton("Back to Main Menu");
        backButton.addActionListener((ActionEvent e) -> {
            successFrame.dispose(); // Close the success frame
            openCustomerMainMenu(); // Open the main menu
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(backButton);
        successFrame.add(buttonPanel, BorderLayout.SOUTH);

        successFrame.setVisible(true);
    }

    private void openCustomerMainMenu() {
        SwingUtilities.invokeLater(() -> {
            CustomerMainMenu mainMenu = new CustomerMainMenu(username, userID, contact);
        });
    }
}
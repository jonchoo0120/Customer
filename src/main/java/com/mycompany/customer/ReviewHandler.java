package com.mycompany.customer;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReviewHandler {

    public static void showReviews(String itemName) {
        JFrame reviewFrame = new JFrame("Reviews for " + itemName);
        reviewFrame.setSize(300, 200);
        reviewFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        DefaultTableModel reviewTableModel = new DefaultTableModel(new String[]{"User", "Review"}, 0);
        JTable reviewTable = new JTable(reviewTableModel);
        centerAlignTable.centerAlignTable(reviewTable);
        JScrollPane reviewScrollPane = new JScrollPane(reviewTable);
        reviewFrame.add(reviewScrollPane);

        // Load and display reviews from ProductsReview.txt
        try {
            Scanner scanner = new Scanner(new File("ProductsReview.txt"));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.equals(itemName)) {
                    while (scanner.hasNextLine()) {
                        String user = scanner.nextLine();
                        if (user.trim().isEmpty()) {
                            break; // End of reviews for the current item
                        }
                        String review = scanner.nextLine();
                        reviewTableModel.addRow(new Object[]{user, review});
                    }
                    break; // Reviews for the current item have been loaded
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        reviewFrame.setLocationRelativeTo(null);
        reviewFrame.setVisible(true);
    }
}
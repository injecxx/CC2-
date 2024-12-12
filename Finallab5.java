package finallab5;

import javax.swing.JOptionPane;

public class Finallab5 {
    public static void main(String[] args) {
        // Initial values for bank account and shopping cart
        double balance = 100000.00;  // Initial balance
        int availableStock = 50;   // Available stock

        while (true) {
            // Menu options for the user
            String[] options = {"Banking System", "Shopping Cart", "Exit"};
            int choice = JOptionPane.showOptionDialog(
                null, 
                "Choose an option:", 
                "Menu", 
                JOptionPane.DEFAULT_OPTION, 
                JOptionPane.PLAIN_MESSAGE, 
                null, 
                options, 
                options[0]  // Default selection (first option)
            );

            if (choice == -1) {
                // This happens when the user closes the dialog or cancels
                break;
            }

            switch (choice) {
                case 0: // Banking System
                    try {
                        String withdrawalString = JOptionPane.showInputDialog("Enter the amount to withdraw: $");
                        double withdrawalAmount = Double.parseDouble(withdrawalString);

                        if (withdrawalAmount > balance) {
                            JOptionPane.showMessageDialog(null, "Error: Not enough funds.");
                        } else {
                            balance -= withdrawalAmount;
                            JOptionPane.showMessageDialog(null, "Withdrawal successful. New balance: $" + balance);
                        }
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Invalid input! Please enter a valid number.");
                    }
                    break;

                case 1: // Shopping Cart System
                    try {
                        String quantityString = JOptionPane.showInputDialog("Enter the quantity of items to add to your cart: ");
                        int quantity = Integer.parseInt(quantityString);

                        if (quantity < 0) {
                            JOptionPane.showMessageDialog(null, "Error: Quantity cannot be negative.");
                        } else if (quantity > availableStock) {
                            JOptionPane.showMessageDialog(null, "Error: Only " + availableStock + " items are available.");
                        } else {
                            availableStock -= quantity; // Decrease available stock
                            JOptionPane.showMessageDialog(null, "Successfully added " + quantity + " item(s) to the cart.");
                        }
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Invalid input! Please enter a valid number.");
                    }
                    break;

                case 2: // Exit
                    JOptionPane.showMessageDialog(null, "Exiting the program. Goodbye!");
                    return;

                default: // Invalid choice (this shouldn't happen)
                    JOptionPane.showMessageDialog(null, "Invalid choice! Please select a valid option.");
                    break;
            }
        }
    }
}
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

class ExpenseTracker extends Frame implements ActionListener {
    TextField descriptionField, amountField, dateField;
    Button addButton, viewButton;
    TextArea displayArea;

    public ExpenseTracker() {
        // Frame setup
        setTitle("Expense Tracker");
        setSize(400, 350);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // Description field
        gbc.gridx = 0; gbc.gridy = 0;
        add(new Label("Description:"), gbc);
        descriptionField = new TextField(20);
        gbc.gridx = 1;
        add(descriptionField, gbc);

        // Amount field
        gbc.gridx = 0; gbc.gridy = 1;
        add(new Label("Amount:"), gbc);
        amountField = new TextField(20);
        gbc.gridx = 1;
        add(amountField, gbc);

        // Date field
        gbc.gridx = 0; gbc.gridy = 2;
        add(new Label("Date (YYYY-MM-DD):"), gbc);
        dateField = new TextField(20);
        gbc.gridx = 1;
        add(dateField, gbc);

        // Add button
        addButton = new Button("Add Expense");
        addButton.addActionListener(this);
        gbc.gridx = 0; gbc.gridy = 3;
        gbc.gridwidth = 2;
        add(addButton, gbc);

        // View button
        viewButton = new Button("View Expenses");
        viewButton.addActionListener(this);
        gbc.gridy = 4;
        add(viewButton, gbc);

        // Display area
        displayArea = new TextArea(10, 30);
        displayArea.setEditable(false);
        gbc.gridy = 5;
        add(displayArea, gbc);

        // Window close event
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        // Make the frame visible
        setVisible(true);
        setLocationRelativeTo(null); // Center the window
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            String description = descriptionField.getText();
            String amount = amountField.getText();
            String date = dateField.getText();
            if (!description.isEmpty() && !amount.isEmpty() && !date.isEmpty()) {
                addExpense(description, amount, date);
                descriptionField.setText("");
                amountField.setText("");
                dateField.setText("");
            } else {
                showMessage("Please fill in all fields.");
            }
        } else if (e.getSource() == viewButton) {
            viewExpenses();
        }
    }

    private void addExpense(String description, String amount, String date) {
        try (PrintWriter out = new PrintWriter(new FileWriter("expenses.txt", true))) {
            out.println(description + "," + amount + "," + date);
            showMessage("Expense added successfully!");
        } catch (IOException e) {
            showMessage("Error saving expense: " + e.getMessage());
        }
    }

    private void viewExpenses() {
        displayArea.setText("");
        try (BufferedReader br = new BufferedReader(new FileReader("expenses.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                displayArea.append(line.replace(",", ": ") + "\n");
            }
        } catch (IOException e) {
            showMessage("Error reading expenses: " + e.getMessage());
        }
    }

    private void showMessage(String message) {
        Dialog dialog = new Dialog(this, "Message", true);
        dialog.setLayout(new FlowLayout());
        dialog.add(new Label(message));
        Button closeButton = new Button("Close");
        closeButton.addActionListener(e -> dialog.dispose());
        dialog.add(closeButton);
        dialog.setSize(300, 150);
        dialog.setVisible(true);
    }

    public static void main(String[] args) {
        new ExpenseTracker();
    }
}

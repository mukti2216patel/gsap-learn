import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.regex.*;

class ExpenssTracker1 extends Frame implements ActionListener {
    TextField dtf;
    TextField atf;
    TextField datef;
    Button addbtn;
    Button vbtn;
    TextArea display;

    ExpenssTracker1() {
        setTitle("Expenss Tracker");
        setSize(400, 350);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new Label("Description"), gbc);

        dtf = new TextField(20);
        gbc.gridx = 1;
        add(dtf, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new Label("Amount"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        add(atf, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new Label("Date (YYYY-MM-DD):"), gbc);

        datef = new TextField(20);
        gbc.gridx = 1;
        gbc.gridy = 2;
        add(datef, gbc);

        addbtn = new Button("Add Expenss");
        addbtn.addActionListener(this);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        add(addbtn, gbc);

        vbtn = new Button("View Expenss");
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        add(vbtn, gbc);

        display = new TextArea(10, 30);
        display.setEditable(false);
        gbc.gridy = 5;
        add(display, gbc);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addbtn) {
            String dsp = dtf.getText();
            String amt = atf.getText();
            String date = datef.getText();

            if (validinputs(dsp, amt, date)) {
                addexpenss(dsp, amt, date);
                dtf.setText("");
                atf.setText("");
                datef.setText("");
            } else if (e.getSource() == vbtn) {
                viewexpenss();
            }
        }
    }

    boolean validinputs(String dsp, String amt, String date) {
        if (dsp.isEmpty() || amt.isEmpty() || date.isEmpty()) {
            ShowMessage("Please Fill the form");
            return false;
        }
        if (!amt.matches("\\d+(\\.\\d{1,2})?")) {
            ShowMessage("Invalid Amount");
            return false;
        }
        if (!validdate(date)) {
            ShowMessage("Date must be in the format YYYY-MM-DD.");
            return false;
        }
        return true;
    }

    void ShowMessage(String text) {
        Dialog dg = new Dialog(this, "Message", true);
        dg.setLayout(new FlowLayout());
        dg.add(new Label(text));
        Button close = new Button("Close");
        close.addActionListener(e -> dg.dispose());
        dg.add(close);
        dg.setSize(300, 150);
        dg.setVisible(true);
    }

    boolean validdate(String date) {
        String datepattern = "\\d{4}-\\d{2}-\\d{2}";
        if (!date.matches(datepattern)) {
            return false;
        }
        try {
            String[] parts = date.split("-");
            int year = Integer.parseInt(parts[0]);
            int month = Integer.parseInt(parts[1]);
            int day = Integer.parseInt(parts[2]);
            if (month < 1 || month > 12)
                return false;

            int[] months = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
            return (day >= 1 && day <= months[month - 1]);
        } catch (Exception e) {
            return false;
        }
    }

    void addexpenss(String dsp, String amt, String date) {
        try (PrintWriter out = new PrintWriter(new FileWriter("Expenss.txt", true))) {
            out.println(dsp + "," + amt + "," + date);
            ShowMessage("Expenss added sucessfully");
        } catch (IOException e) {
            ShowMessage("Error saving expenss " + e.getMessage());

        }
    }

    void viewexpenss() {
        display.setText(" ");
        try(BufferedReader br = new BufferedReader(new FileReader("Expenss.txt")))
        {
            String line;
            while((line = br.readLine()) != null)
            {
                display.append(line.replace(',' , ':'));
            }
        }
        catch(IOException e)
        {
            ShowMessage("Error reading expenss " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        new ExpenseTracker();
    }
}
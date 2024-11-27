import java.awt.*;
import java.awt.event.*;

class gui2 extends Frame implements ActionListener {
    TextField tf1;
    Button b1;

    gui2() {
        setSize(300, 300);
        setLayout(new FlowLayout());

        tf1 = new TextField();
        b1 = new Button("Calc Eligibility");

        add(tf1);
        add(b1);

        b1.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String input = tf1.getText();
      
            int age = Integer.parseInt(input);

            if (age >= 18) {
                makedia(this, "You are eligible!");
            } else {
                makedia(this, "You are not eligible.");
            }
    }

    static void makedia(Frame parent, String message) {
        Dialog md = new Dialog(parent, "Eligibility", true);

        md.setSize(200, 100);
        md.setLayout(new FlowLayout());

        Label mdl = new Label(message);

        md.add(mdl);

        md.setVisible(true);
    }

    public static void main(String[] args) {
        new gui2();
    }
}

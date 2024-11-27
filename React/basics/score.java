import java.awt.*;
import java.awt.event.*;

class score extends Frame implements ActionListener {
    Label l1, l2, l3, l4;
    Button b1, b2, b3;

    score() {
        // Set size and layout
        setSize(300, 200);
        setLayout(new GridBagLayout());
        
        // Create labels
        l1 = new Label("Red score");
        l2 = new Label("Blue score");
        l3 = new Label("0");
        l4 = new Label("0");

        // Create GridBagConstraints object for positioning
        GridBagConstraints gbc = new GridBagConstraints();

        // First label (Red score)
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;  // Each label takes one cell horizontally
        gbc.gridheight = 1; // Each label takes one cell vertically
        add(l1, gbc);

        // Second label (Blue score)
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(l2, gbc);

        // Third label (0 for Red score)
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(l3, gbc);

        // Fourth label (0 for Blue score)
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(l4, gbc);

        // Optionally, you can add buttons or other components here
        // Just for example, let's add 3 buttons
        b1 = new Button("Increase Red");
        b2 = new Button("Increase Blue");
        b3 = new Button("Reset");

        // Button for "Increase Red"
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(b1, gbc);

        // Button for "Increase Blue"
        gbc.gridx = 1;
        gbc.gridy = 2;
        add(b2, gbc);

        // Button for "Reset"
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill=1;
        gbc.gridwidth=4; // This button should span both columns
        add(b3, gbc);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        // Make the frame visible
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == b1)
        {
            String s = l3.getText();
            int a = Integer.parseInt(s);
            l3.setText(String.valueOf(a+1));
        }
        else if(e.getSource() == b2)
        {
            String s = l4.getText();
            int a = Integer.parseInt(s);
            l4.setText(String.valueOf(a+1));
        }
        else{
            l3.setText("0");
            l4.setText("0");
        }
    }
    public static void main(String args[]) {
        new score();
    }
}

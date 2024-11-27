import java.awt.*;
import java.awt.event.*;

public class ColorCycle extends Frame implements ActionListener {
    private Button button;
    private int colorState = 0;

    public ColorCycle() {
        setVisible(true);
        setSize(300, 200);
        setLayout(new FlowLayout());
        button = new Button("Change Color");
        button.addActionListener(this);
        add(button);
        setBackground(Color.RED);
    }

    public void actionPerformed(ActionEvent e) {
        if (colorState == 0) {
            setBackground(Color.GREEN);
            colorState = 1;
        } else if (colorState == 1) {
            setBackground(Color.BLUE);
            colorState = 2;
        } else if (colorState == 2) {
            setBackground(Color.RED);
            colorState = 0;
        }
    }

    public static void main(String[] args) {
        new ColorCycle();
    }
}

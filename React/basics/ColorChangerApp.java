import java.awt.*;
import java.awt.event.*;

public class ColorChangerApp extends Frame {
    private List colorList;
    private Canvas canvas;
    private Label colorLabel;

    public ColorChangerApp() {
        setTitle("Color Changer Application");
        setSize(400, 300);
        setLayout(new BorderLayout());
        // setBackground(Color.LIGHT_GRAY);

        colorList = new List();
        canvas = new Canvas();
        colorLabel = new Label("Selected Color: None", Label.CENTER);

        colorList.add("Red");
        colorList.add("Green");
        colorList.add("Blue");
        colorList.add("Yellow");
        colorList.add("Orange");
        colorList.add("Black");
        colorList.add("White");

        add(colorList, BorderLayout.WEST);
        add(canvas, BorderLayout.CENTER);
        add(colorLabel, BorderLayout.SOUTH);

        colorList.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String selectedColor = colorList.getSelectedItem();
                colorLabel.setText("Selected Color: " + selectedColor);

                switch (selectedColor) {
                    case "Red":
                        canvas.setBackground(Color.RED);
                        break;
                    case "Green":
                        canvas.setBackground(Color.GREEN);
                        break;
                    case "Blue":
                        canvas.setBackground(Color.BLUE);
                        break;
                    case "Yellow":
                        canvas.setBackground(Color.YELLOW);
                        break;
                    case "Orange":
                        canvas.setBackground(Color.ORANGE);
                        break;
                    case "Black":
                        canvas.setBackground(Color.BLACK);
                        break;
                    case "White":
                        canvas.setBackground(Color.WHITE);
                        break;
                    default:
                        canvas.setBackground(Color.LIGHT_GRAY);
                        break;
                }
            }
        });

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        ColorChangerApp app = new ColorChangerApp();
        app.setVisible(true);
    }
}

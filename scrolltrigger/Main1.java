import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

class Main1 {
    public static void main(String[] args) {
        new TextEditor();
    }
}

class TextEditor extends Frame implements ActionListener {

    TextArea textArea;
    Label fontLabel;
    Button fontColorButton;
    Button countWordsButton; // New button for counting words
    TextField fontSizeField;
    MenuBar menuBar;
    Menu fileMenu;
    MenuItem openItem;
    MenuItem saveItem;
    MenuItem exitItem;

    TextEditor() {
        this.setTitle("Bro Text Editor");
        this.setSize(500, 500);
        this.setLayout(new FlowLayout());
        this.setLocationRelativeTo(null);

        textArea = new TextArea(20, 50);
        textArea.setFont(new Font("Arial", Font.PLAIN, 20));

        fontLabel = new Label("Font Size: ");
        fontSizeField = new TextField("20", 3);
        fontSizeField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int size = Integer.parseInt(fontSizeField.getText());
                    textArea.setFont(new Font(textArea.getFont().getName(), Font.PLAIN, size));
                } catch (NumberFormatException ex) {
                    // Handle invalid input
                    fontSizeField.setText(String.valueOf(textArea.getFont().getSize())); // Reset to current font size
                }
            }
        });

        fontColorButton = new Button("Color");
        fontColorButton.addActionListener(this);

        // New button for counting words
        countWordsButton = new Button("Count Words");
        countWordsButton.addActionListener(this);

        // Menu bar
        menuBar = new MenuBar();
        fileMenu = new Menu("File");
        openItem = new MenuItem("Open");
        saveItem = new MenuItem("Save");
        exitItem = new MenuItem("Exit");

        openItem.addActionListener(this);
        saveItem.addActionListener(this);
        exitItem.addActionListener(this);

        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(exitItem);
        menuBar.add(fileMenu);

        this.setMenuBar(menuBar);
        this.add(fontLabel);
        this.add(fontSizeField);
        this.add(fontColorButton);
        this.add(countWordsButton); // Add count words button to the layout
        this.add(textArea);
        this.setVisible(true);
        
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == fontColorButton) {
            ColorDialog colorDialog = new ColorDialog(this, "Choose a color", true);
            colorDialog.setVisible(true);
            Color color = colorDialog.getColor();
            if (color != null) {
                textArea.setForeground(color);
            }
        }

        // Handle Count Words button click
        if (e.getSource() == countWordsButton) {
            String text = textArea.getText().trim();
            int wordCount = text.isEmpty() ? 0 : text.split("\\s+").length; // Count words by splitting on whitespace
            // Show word count in a dialog
            Dialog wordCountDialog = new Dialog(this, "Word Count", true);
            wordCountDialog.setSize(200, 100);
            wordCountDialog.setLayout(new FlowLayout());
            wordCountDialog.add(new Label("Word Count: " + wordCount));
            Button okButton = new Button("OK");
            okButton.addActionListener(ae -> wordCountDialog.setVisible(false));
            wordCountDialog.add(okButton);
            wordCountDialog.setLocationRelativeTo(this);
            wordCountDialog.setVisible(true);
        }

        if (e.getSource() == openItem) {
            FileDialog fileDialog = new FileDialog(this, "Open", FileDialog.LOAD);
            fileDialog.setVisible(true);
            String filePath = fileDialog.getDirectory() + fileDialog.getFile();

            if (filePath != null && fileDialog.getFile() != null) { // Check if file is not null
                try (Scanner fileIn = new Scanner(new File(filePath))) {
                    textArea.setText(""); // Clear existing text
                    while (fileIn.hasNextLine()) {
                        textArea.append(fileIn.nextLine() + "\n");
                    }
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
            }
        }

        if (e.getSource() == saveItem) {
            FileDialog fileDialog = new FileDialog(this, "Save", FileDialog.SAVE);
            fileDialog.setVisible(true);
            String filePath = fileDialog.getDirectory() + fileDialog.getFile();

            if (filePath != null && fileDialog.getFile() != null) { // Check if file is not null
                try (PrintWriter fileOut = new PrintWriter(new File(filePath))) {
                    fileOut.println(textArea.getText());
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
            }
        }

        if (e.getSource() == exitItem) {
            System.exit(0);
        }
    }
}

class ColorDialog extends Dialog {
    private Color color;

    ColorDialog(Frame owner, String title, boolean modal) {
        super(owner, title, modal);
        setLayout(new FlowLayout());
        setSize(400, 400);
        setLocationRelativeTo(owner);

        // Create color buttons
        for (Color c : new Color[]{Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.BLACK, Color.GRAY, Color.WHITE}) {
            Button button = new Button();
            button.setBackground(c);
            button.setPreferredSize(new Dimension(100, 100));
            button.addActionListener(e -> {
                color = c;
                setVisible(false);
            });
            add(button);
        }

        Button cancelButton = new Button("Cancel");
        cancelButton.addActionListener(e -> setVisible(false));
        add(cancelButton);
    }

    Color getColor() {
        return color;
    }
}

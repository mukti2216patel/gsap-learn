import java.awt.*;
public class layout1 extends Frame {
    Button b1 , b2 , b3;
    Label l1 , l2;
    TextField tf1;
    Panel p1 , p2 , p3;
    layout1()
    {
        setSize(300,300);
        setLayout(new BorderLayout());
        b1 = new Button("b1");
        b2 = new Button("b2");
        b3 = new Button("b3");
        l1 = new Label("l1");
        l2 = new Label("l2");
        tf1 = new TextField(10);

        p1 = new Panel();
        p1.setLayout(new FlowLayout());
        p1.add(b1);
        p1.add(b2);

        p2 = new Panel();
        p2.setLayout(new GridLayout(2, 1));  // 2 rows, 1 column (vertical layout)
        p2.add(l1);
        p2.add(l2);

        add(p1,BorderLayout.NORTH);
        add(p2,BorderLayout.WEST);
         
        p3 = new Panel();
        p3.setLayout(new GridLayout(2,1));
        p3.add(tf1);
        p3.add(b3);
        add(p3 , BorderLayout.CENTER);
        setVisible(true);

    }
    public static void main(String[] args) {
        new layout1();
    }
}

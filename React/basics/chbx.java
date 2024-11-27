import java.util.*;
import java.awt.*;
// import java.awt.event.ActionListener;
import java.awt.event.*;
public class chbx extends Frame implements ItemListener{
    Checkbox c1 , c2 , c3;
    Canvas can;
    chbx()
    {
        setSize(300, 200);
        setLayout(new FlowLayout());
        c1 = new Checkbox("Red" );
        c2 = new Checkbox("Green");
        c3 = new Checkbox("Blue");
        c1.addItemListener(this);
        c2.addItemListener(this);
        c3.addItemListener(this);
        add(c1);
        add(c2);
        add(c3);
        can = new Canvas();
        can.setSize(50,50);
        can.setBackground(Color.BLACK);
        add(can);
        setVisible(true);
    }
    public void itemStateChanged(ItemEvent e) {
        if(c1.getState() && c2.getState())
        {
            can.setBackground(Color.YELLOW);
        }
        else if(c1.getState() && c3.getState())
        {
            can.setBackground(Color.CYAN);
        }
        else if(c2.getState() && c3.getState())
        {
            can.setBackground(Color.MAGENTA);
        }
        else if(c1.getState())
        {
            can.setBackground(Color.RED);
        }
        else if(c2.getState())
        {
            can.setBackground(Color.GREEN);
        }
        else if(c3.getState()){
            can.setBackground(Color.BLUE);
        }
        else{
            can.setBackground(Color.BLACK);
        }
    }
    public static void main(String args[])
    {
        chbx c1 = new chbx();

    }
}

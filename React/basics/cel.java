import java.awt.*;
import java.awt.event.*;

public class cel extends Frame implements ItemListener{
    TextField iptf, optf;
    Label ip, ipsc, opsc, op;
    Checkbox c1, c2, c3, b1, b2, b3;
    CheckboxGroup c, b;
    Panel ep,wp,p,pq;
    cel() {
        setVisible(true);
        setSize(300, 300);
        setLayout(new BorderLayout());

        // Panel for Input Label and TextField
        ip = new Label("Input");
        iptf = new TextField(5);
        p = new Panel();
        p.setLayout(new FlowLayout());
        p.add(ip);
        p.add(iptf);
        add(p, BorderLayout.NORTH);

        // Panel for Output Label and TextField
        op = new Label("Output");
        optf = new TextField(5);
        pq = new Panel();
        pq.setLayout(new FlowLayout());
        pq.add(op);
        pq.add(optf);
        add(pq, BorderLayout.SOUTH);

        // Panel for Input Scale Label and Checkboxes
        ipsc = new Label("Input Scale");
        c = new CheckboxGroup();
        c1 = new Checkbox("Celsius", false, c);
        c2 = new Checkbox("Fahrenheit", false, c);
        c3 = new Checkbox("Kelvin", false, c);
         ep = new Panel();
        ep.setLayout(new GridLayout(4,0));
        ep.add(ipsc);  // Adding label to the panel
        ep.add(c1);    // Adding checkboxes to the panel
        ep.add(c2);
        ep.add(c3);
        add(ep, BorderLayout.WEST);

        // Panel for Output Scale Checkboxes
        wp = new Panel();
        wp.setLayout(new GridLayout(4,0));
        b = new CheckboxGroup();
        opsc = new Label("Output Scale");
        b1 = new Checkbox("Celsius", false, b);
        b2 = new Checkbox("Fahrenheit", false, b);
        b3 = new Checkbox("Kelvin", false, b);
        wp.add(opsc);
        wp.add(b1);    // Adding checkboxes to the panel
        wp.add(b2);
        wp.add(b3);
        add(wp, BorderLayout.EAST);
        c1.addItemListener(this);
        c2.addItemListener(this);
        c3.addItemListener(this);
        b1.addItemListener(this);
        b2.addItemListener(this);
        b3.addItemListener(this);
    }
    String getInputScale() {
        if (c1.getState()) {
            return "Celsius";
        } else if (c2.getState()) {
            return "Fahrenheit";
        } else if (c3.getState()) {
            return "Kelvin";
        }
        return null;
    }
    String getOutputScale() {
        if (b1.getState()) {
            return "Celsius";
        } else if (b2.getState()) {
            return "Fahrenheit";
        } else if (b3.getState()) {
            return "Kelvin";
        }
        return null;
    }
    void convert(String iptype , String optype , Double fval)
    {
        Double result = fval;
        if (iptype.equals("Celsius")) {
            if (optype.equals("Fahrenheit")) {
                result = (fval * 9/5) + 32;
            } else if (optype.equals("Kelvin")) {
                result = fval + 273.15;
            }
        } else if (iptype.equals("Fahrenheit")) {
            if (optype.equals("Celsius")) {
                result = (fval - 32) * 5/9;
            } else if (optype.equals("Kelvin")) {
                result = (fval - 32) * 5/9 + 273.15;
            }
        } else if (iptype.equals("Kelvin")) {
            if (optype.equals("Celsius")) {
                result = fval - 273.15;
            } else if (optype.equals("Fahrenheit")) {
                result = (fval - 273.15) * 9/5 + 32;
            }
        }
        optf.setText(String.format("%.2f", result));
    }
    public void itemStateChanged(ItemEvent e)
    {
        String iptype = getInputScale();
        String optype = getOutputScale();
        String ipval = iptf.getText();
        Double fval = Double.parseDouble(ipval);
        convert(iptype , optype , fval);
    }   
    public static void main(String args[]) {
        new cel();
    }
}

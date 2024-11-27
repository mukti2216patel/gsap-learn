import java.awt.*;
import java.awt.event.*;
class click extends Frame implements MouseListener{
    int x , y;
    click()
    {
        setSize(300,300);
        addMouseListener(this);
        setVisible(true);
    }
    public void mouseClicked(MouseEvent e)
    {
        x = e.getX();
        y = e.getY();
        repaint();
    }
    public void paint(Graphics g)
    {
        g.drawOval(x , y , 5, 5);
        g.setColor(Color.RED);
        g.fillOval(x,y , 5 , 5);
    }
    public void mousePressed(MouseEvent e)
    {}
    public void mouseReleased(MouseEvent e)
    {}
    public void mouseEntered(MouseEvent e)
    {}
    public void mouseExited(MouseEvent e)
    {}
        public static void main(String[] args) {
            new click();
        }
}

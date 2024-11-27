import java.util.*;
interface configure{
        public void on1();
        public void off1();
}
interface control{
    public void setconf(int a );
}
public class twointer implements control , configure{
    int bright;
    int v ;
    twointer()
    {
        bright =0;
        v=0;
    }
    public void on1()
    {
        bright = 1;
    }
    public void off1()
    {
        bright =0;
    }
    public void setconf(int a)
    {
        if(bright == 1)
        System.out.println("light on");
        else
        System.out.println("light off");

        v=a;
        System.out.println("volt : " + v);
    }
    public static void main(String args[])
    {
        twointer t = new twointer();
        Scanner sc = new Scanner(System.in);
        int volt = sc.nextInt();
        t.on1();
        t.setconf(volt);
        t.off1();
    }
}

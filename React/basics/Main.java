import java.util.Scanner;

class Main{
    int acc = 20000;
    synchronized void withdraw(int a) throws Exception
    {
        if(a > acc)
        {
            System.out.println("Insufficient balance");
            throw new Exception("low balance");
        }
        else
        {
            System.out.println("withdrawal sucessfull");
            System.out.println("current account balance : " + (acc-a));
        }
    }
    public static void main(String args[])
    {
        Main m1 = new Main();
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        try{
            m1.withdraw(a);
        }
        catch(Exception e)
        {
            System.out.println("current account balance is : " + m1.acc);
            System.out.println("enter the amount of deposit");
           int b = sc.nextInt();
           m1.acc += b;
           System.out.println("current account balance : " + m1.acc);
        }
       
    }
}
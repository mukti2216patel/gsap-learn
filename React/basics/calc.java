import java.util.*;
class calc  {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        String n2 = sc.next();
        if(n2.isEmpty())
        {
            try{
                throw new Exception("plz enter input");
            }
            catch(Exception e)
            {
                System.out.println(e.getMessage());
                System.exit(0);
            }
        }
        char a = sc.next().charAt(0);
        int n3 = Integer.parseInt(n2);
        if(a=='+')
        {
            System.out.println(n1+n3);
        }
        else if(a=='-')
        {
            System.out.println(n1-n3);
        }
        else if(a=='*')
        {
            System.out.println(n1*n3);
        }
        else
        {
            if(n3==0)
            {
                try{
                    throw new ArithmeticException("plz enter non zero number");
                }
                catch(ArithmeticException e)
                {
                    System.out.println(e.getMessage());
                    System.exit(0);
                }
            }
            System.out.println(n1/n3);
        } 
    }
}

import java.util.*;
public class ecom {
        static double calc(int n )
        {
            int nn = n + ((n * 7)/100);
            return nn;
        }
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            String name = sc.next();
            if(n<=0)
            {
                try{
                    throw new Exception("price cant be zero");
                }
                catch(Exception e)
                {
                    System.out.println(e.getMessage());
                }
            }
            if(name == "")
            {
                try{
                    throw new Exception("plz enter name");
                }
                catch(Exception e)
                {
                    System.out.println(e.getMessage());
                }
            }
            double d1 = calc(n);
            if(d1<=0)
            {
                try{
                    throw new Exception("price cant be zero");
                }
                catch(Exception e)
                {
                    System.out.println(e.getMessage());
                }
            }
           System.out.println(d1);
        }
}

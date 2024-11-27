import java.util.*;
interface arithmeticunit{
    public int divisor_sum(int n);
};
class p1 implements arithmeticunit{
    public int divisor_sum(int n)
    {
        int sum = 0;
        while(n!=0)
        {
            sum += n%10;
            n/=10;
        }
        return sum;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        if(s.endsWith(".com"))
        {
            System.out.println("com");
        }
        String a[] = s.split(":");
        System.out.println(a[0]);
        recur(1,5,0);
        matf(3,3);
        p1 p = new p1();
        System.out.println(p.divisor_sum(123));
    }
    static void recur(int i , int n , int sum)
    {
        if(n==0) 
        {
            System.out.println(sum);
            return;
        }
        recur(i+2,n-1, sum+i);
    }
    static void matf(int r , int c)
    {
        int a[][] = new int[r][c];
        int a1[][] = a;
        for(int i = 0 ; i < r ; i++)
        {
            for(int j = 0 ; j < c ; j++)
            {
                a[i][j]=i+j;
            }
        }
        int sr =0;
        for(int i=0;i<r;i++)
        {
            sr=0;
            for(int j=0;j<c;j++)
            {
                sr+=a[i][j];
            }
            System.out.println(sr);
        }
        for(int i=0;i<c;i++)
        {
            sr=0;
            for(int j=0;j<r;j++)
            {
                sr+=a[j][i];
            }
            System.out.println(sr);
        }
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                a1[i][j] = a[j][i];
                System.out.print(a1[i][j] + " ");
            }
        }
    }
}
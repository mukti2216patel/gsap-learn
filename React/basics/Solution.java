import java.util.Scanner;

class MyCalculator {

    public long power(int n, int p) throws Exception {
        if (n < 0 || p < 0) {
            throw new Exception("N or P should not be negative");
        }
        if (n == 0 && p == 0) {
            throw new Exception("N and P should not be Zero");
        }
        return (long) Math.pow(n, p);
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyCalculator myCalculator = new MyCalculator();
        
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int p = sc.nextInt();
            try {
                long result = myCalculator.power(n, p);
                System.out.println(result);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        sc.close();
    }
}

package ETC;

import java.math.BigInteger;
import java.util.Scanner;

public class q2407 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.close();

        BigInteger a = BigInteger.ONE;
        BigInteger b = BigInteger.ONE;

        //n! / (n-m)!m!
        for(int i=0; i<m; i++) {
            a = a.multiply(new BigInteger(String.valueOf(n - i)));  //n! / (n-m)!
            b = b.multiply(new BigInteger(String.valueOf(i + 1)));  //m!
        }

        BigInteger ans = a.divide(b);
        System.out.print(ans);

    }
}

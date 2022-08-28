package Chap14_정수론및조합론;

import java.util.Scanner;

public class q1934 {

    static int gcd(int a, int b) {
        if(b == 0)
            return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        while(n-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = gcd(a, b);
            int d = a * b / c;
            System.out.println(d);
        }
        sc.close();
    }
}

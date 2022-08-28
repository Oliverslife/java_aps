package Chap14_정수론및조합론;

import java.util.Scanner;

public class q3036 {
    static int gcd(int a, int b) {
//        if(b == 0)
//            return a;
//        return gcd(b, a % b);
        int x;
        while(b != 0) {
            x = a % b;
            a = b;
            b = x;
        }
        return a;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int start = sc.nextInt();
        while(--n > 0) {
            int next = sc.nextInt();
            int cal = gcd(start, next);
            System.out.println(start / cal + "/" + next / cal);
        }
        sc.close();
    }
}

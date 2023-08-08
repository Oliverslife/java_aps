package Chap14_정수론및조합론;

import java.util.Scanner;

public class q2609 {

    static int rec(int a, int b) {
        if(b == 0)
            return a;
        return rec(b, a % b);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        sc.close();
        int c = rec(a, b);
        int d = a * b / c;

        System.out.println(c);
        System.out.println(d);

    }
}

package Chap02_조건문;

import java.util.Scanner;

public class q2480 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        sc.close();

        if (a == b && b == c)
            System.out.print(10000 + a * 1000);
        else if (a == b || b == c)
            System.out.print(1000 + b * 100);
        else if (a == c)
            System.out.print(1000 + a * 100);
        else
            System.out.print(100 * Math.max(Math.max(a, b), c));
    }
}

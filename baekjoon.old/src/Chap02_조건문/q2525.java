package Chap02_조건문;

import java.util.Scanner;

public class q2525 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        sc.close();
        int t = a * 60 + b + c;

        a = t / 60;
        b = t % 60;
        if (a >= 24)
            a -= 24;

        System.out.print(a + " " + b);

    }
}

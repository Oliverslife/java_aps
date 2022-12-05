package Chap02_조건문;

import java.util.Scanner;

public class q2884 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int m = sc.nextInt();
        sc.close();
        int t = h * 60 + m - 45;

        if (t < 0)
            t += 24 * 60;
        h = t / 60;
        m = t % 60;

        System.out.print(h + " " + m);
    }
}

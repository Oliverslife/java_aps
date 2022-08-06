package Chap02_조건문;

import java.util.Scanner;

public class q14681 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        sc.close();

        if (x > 0) {
            if (x*y > 0)
                System.out.print(1);
            else
                System.out.print(4);
        }
        else {
            if (x*y > 0)
                System.out.print(3);
            else
                System.out.print(2);
        }
    }
}

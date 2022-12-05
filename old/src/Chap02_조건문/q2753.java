package Chap02_조건문;

import java.util.Scanner;

public class q2753 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int y = sc.nextInt();
        boolean is_y = false;
        sc.close();

        if(y % 400 == 0) {
            is_y = true;
        } else if (y % 4 == 0 && y % 100 != 0) {
            is_y = true;
        }

        if (is_y)
            System.out.print(1);
        else
            System.out.print(0);
    }
}

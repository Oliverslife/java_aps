package Chap03_반복문;

import java.util.Scanner;

public class q10950 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a;
        int b;

        for(int i=0; i<n; i++) {
            a = sc.nextInt();
            b = sc.nextInt();
            System.out.println(a + b);
        }

        sc.close();
    }
}

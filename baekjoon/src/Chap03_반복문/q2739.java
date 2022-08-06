package Chap03_반복문;

import java.util.Scanner;

public class q2739 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        for(int i=1; i<10; i++) {
            System.out.printf("%d * %d = %d\n", n, i, n * i);
        }
    }
}

package Chap05_함수;

import java.util.Scanner;

public class q1065 {
    static int hansu(int n) {
        int is_Hansu = 0;
        int a = n % 10;
        int b = (n / 10) % 10;
        int c = n / 100;

        if(a-b == b-c)
            is_Hansu = 1;

        return is_Hansu;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        int ans = 99;

        if (n<100) {
            System.out.print(n);
        }
        else {
            for(int i=100; i<=n; i++) {
                ans += hansu(i);
            }
            System.out.print(ans);
        }
    }
}

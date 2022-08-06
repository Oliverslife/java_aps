package Chap03_반복문;

import java.util.Scanner;

public class q8393 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        int ans = 0;

        for(int i=1; i<=n; i++) {
            ans += i;
        }
        System.out.print(ans);
    }
}

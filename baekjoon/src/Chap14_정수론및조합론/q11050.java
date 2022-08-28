package Chap14_정수론및조합론;

import java.util.Scanner;

public class q11050 {//파스칼의 삼각형, 조합공식, dp

    static int sol(int n, int k) {
        if(n == k || k == 0)
            return 1;
        return sol(n - 1, k - 1) + sol(n - 1, k);
    }

    static int fac(int n) {
        if(n == 0)
            return 1;
        return n * fac(n - 1);
    }

    static int[][] arr;
    static int dp(int n, int k) {

        if(arr[n][k] > 0)
            return arr[n][k];
        if(n == k || k == 0)
            return arr[n][k] = 1;
        return arr[n][k] = dp(n - 1, k - 1) + dp(n - 1, k);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        System.out.print(sol(sc.nextInt(), sc.nextInt()));
//        sc.close();

        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.close();
//        System.out.print(fac(n) / (fac(k) * fac(n-k)));

        arr = new int[n+1][k+1];
        System.out.print(dp(n, k));

    }
}

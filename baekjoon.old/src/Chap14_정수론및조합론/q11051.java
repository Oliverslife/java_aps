package Chap14_정수론및조합론;

import java.util.Scanner;

public class q11051 {
    static int[][] arr;
    static int dp(int n, int k) {

        if(arr[n][k] > 0)
            return arr[n][k];
        if(n == k || k == 0)
            return arr[n][k] = 1;
        return arr[n][k] = (dp(n - 1, k - 1) + dp(n - 1, k)) % 10007;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.close();

        arr = new int[n+1][k+1];
        System.out.print(dp(n, k));
    }
}

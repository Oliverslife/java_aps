package Chap14_정수론및조합론;

import java.util.Scanner;

public class q1010 {
    static int[][] arr = new int[30][30];;
    static int dp(int n, int k) {

        if(arr[n][k] > 0)
            return arr[n][k];
        if(n == k || k == 0)
            return arr[n][k] = 1;
        return arr[n][k] = (dp(n - 1, k - 1) + dp(n - 1, k));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            System.out.println(dp(m, n));
        }
        sc.close();
    }
}

package Selected_07_Memoization;

import java.util.Scanner;

public class q1463 {

    static int[] dp;

    static int recur(int a) {
        if(a == 1)
            return 0;

        if(dp[a] != 0)
            return dp[a];

        int t1 = a % 3 == 0 ? recur(a/3) + 1 : Integer.MAX_VALUE;
        int t2 = a % 2 == 0 ? recur(a/2) + 1 : Integer.MAX_VALUE;

        return dp[a] = Math.min(recur(a-1) + 1, Math.min(t1, t2));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        int a, b;
        int size = n < 4 ? 4 : n + 1;
//        int[] dp = new int[size];
        dp = new int[size];
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;

//        if(n > 3)
//        	for(int i=4; i<=n; i++) {
//        		a = i % 3 == 0 ? dp[i/3] + 1 : Integer.MAX_VALUE;
//        		b = i % 2 == 0 ? dp[i/2] + 1 : Integer.MAX_VALUE;
//        		dp[i] = Math.min(dp[i-1] + 1, Math.min(a, b));
//        	}
        recur(n);
        System.out.println(dp[n]);

    }
}
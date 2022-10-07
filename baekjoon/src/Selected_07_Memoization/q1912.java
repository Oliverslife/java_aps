package Selected_07_Memoization;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class q1912 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] data = new int[n+1];
        for(int i=1; i<=n; i++)
            data[i] = sc.nextInt();
        sc.close();

        int size = n < 1 ? 2 : n+1;
        int[] dp = new int[size];
        dp[1] = data[1];
        if(n > 1)
            for(int i=2; i<=n; i++)
                dp[i] = Math.max(dp[i-1] + data[i], data[i]);

        int max = Integer.MIN_VALUE;
        for(int i=1; i<=n; i++)
            max = Math.max(max, dp[i]);

        System.out.println(max);
    }
}
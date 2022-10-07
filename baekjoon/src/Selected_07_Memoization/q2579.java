package Selected_07_Memoization;

import java.util.Scanner;

public class q2579 {

    static int[] data, dp;

    static int a(int b) {
        if(b == 0)
            return 0;
        if(dp[b] != 0)
            return dp[b];
        return dp[b] = Math.max(a(b-3) + data[b-1] + data[b], a(b-2) + data[b]);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        data = new int[301];
        for(int i=1; i<=n; i++)
            data[i] = sc.nextInt();
        sc.close();

        dp = new int[301];
        dp[1] = data[1];
        dp[2] = data[1] + data[2];
//		if(n >= 3)
//			for(int i=3; i<=n; i++)
//				dp[i] = Math.max(dp[i-3] + data[i-1] + data[i], dp[i-2] + data[i]);

        System.out.println(a(n));

    }

}
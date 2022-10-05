package Selected_07_Memoization;

import java.util.Scanner;

public class q9095 {

    static int n;
    static int[] dp = new int[101];

    static int recur(int a) {
        if(dp[a] != 0)
            return dp[a];
        return dp[a] = recur(a - 1) + recur(a - 2) + recur(a - 3);
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        int T = sc.nextInt();
        while(T-- > 0) {
            n = sc.nextInt();

//            if(dp[n] == 0)
//                for(int i=4; i<=n; i++)
//                    dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
//            sb.append(dp[n]).append("\n");

            sb.append(recur(n)).append("\n");

        }
        sc.close();
        System.out.print(sb);
    }
}

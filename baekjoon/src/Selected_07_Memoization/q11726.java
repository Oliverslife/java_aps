package Selected_07_Memoization;

import java.util.Scanner;

public class q11726 {

    static int[] dp = new int[1001];
    static int a(int b) {
        if(dp[b] != 0)
            return dp[b];
        return dp[b] = (a(b-1) + a(b-2)) % 10007;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

//        int[] dp = new int[1001];
        dp[1] = 1;
        dp[2] = 2;
//        if(n >= 3)
//            for(int i=3; i<=n; i++)
//                dp[i] = (dp[i-1] + dp[i-2]) % 10007;
        System.out.print(a(n));
    }
}

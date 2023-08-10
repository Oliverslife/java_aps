package ETC;

import java.util.Scanner;

public class b2133 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();

        int[] dp = new int[31];
        int add;
        dp[2] = 3;
        for (int i = 4; i < 31; i += 2) {
            add = 0;
            for (int j = i - 4; j > 0; j -= 2)
                add += dp[j] * 2;
            dp[i] = dp[i - 2] * 3 + 2 + add;
        }

        System.out.println(dp[N]);
    }
}
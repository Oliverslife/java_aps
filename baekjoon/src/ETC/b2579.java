package ETC;

import java.util.Scanner;

public class b2579 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N + 1];
        int[] dp = new int[N + 1];
        for (int i = 1; i <= N; i++)
            arr[i] = sc.nextInt();
        sc.close();

        dp[1] = arr[1];
        if (N > 1)
            dp[2] = arr[1] + arr[2];
        for (int i = 3; i <= N; i++)
            dp[i] = Math.max(arr[i - 1] + dp[i - 3], dp[i - 2]) + arr[i];

        System.out.println(dp[N]);
    }
}
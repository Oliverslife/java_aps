package ETC;

import java.util.Scanner;

public class q1003 {

    static Integer[][] dp = new Integer[41][2];;
    static Integer[] fibonacci(int n) {
        // n에 대한 0, 1의 호출 횟수가 없을 떄(탐색하지 않은 값일 떄)
        if(dp[n][0] == null || dp[n][1] == null) {
            //각 n에 대한 0 호출 횟수와 1 호출 횟수를 재귀호출.
            dp[n][0] = fibonacci(n-1)[0] + fibonacci(n-2)[0];
            dp[n][1] = fibonacci(n-1)[1] + fibonacci(n-2)[1];
        }
        // n에 대한 0과 1, 즉 [n][0]과 [n][1]을 담고있는 [n]을 반환한다.
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        dp[0][0] = 1;       //n = 0일 때의 0 호출 횟수
        dp[0][1] = 0;       //n = 1일 때의 1 호출 횟수
        dp[1][0] = 0;
        dp[1][1] = 1;

        int t = sc.nextInt(), n;

        while(t-- > 0) {

            n = sc.nextInt();
            fibonacci(n);
            System.out.println(dp[n][0] + " " + dp[n][1]);

        }
        sc.close();
    }
}

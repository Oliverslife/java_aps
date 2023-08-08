package Selected_04_BruteForce;

import java.io.*;

public class q17626 {   //https://comain.tistory.com/306 설명 읽고 풀이함.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] dp = new int[100000];
        int ans = 0;
        dp[1] = 1;

        int n = Integer.parseInt(br.readLine());
        for(int i=2; i<=n; i++) {
            int min = Integer.MAX_VALUE;
            for(int j=1; j*j<=i; j++)
                min = Math.min(min, dp[i - j * j]);
            dp[i] = min + 1;
        }

        bw.write(dp[n] + "");
        bw.flush();
        bw.close();
        br.close();
    }
}

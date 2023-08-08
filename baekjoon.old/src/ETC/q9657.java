package ETC;

import java.io.*;

public class q9657 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
//        String ans = N % 7 == 0 || N % 7 == 2 ? "CY" : "SK";


        int[] dp = new int[1001];
        dp[1] = 1;
        dp[2] = 0;
        dp[3] = 1;
        dp[4] = 1;  //주어진 조건

        if(N >= 5)
            for(int i=5; i<N+1; i++)
                if(dp[i-1] + dp[i-3] + dp[i-4] < 3)
                    dp[i] = 1;

        String ans = dp[N] == 1 ? "SK" : "CY";
        bw.write(ans);

        bw.flush();
        bw.close();
        br.close();
    }
}

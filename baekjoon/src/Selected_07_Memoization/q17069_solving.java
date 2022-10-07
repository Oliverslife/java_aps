package Selected_07_Memoization;

import java.io.*;
import java.util.StringTokenizer;

public class q17069_solving {

    static int n;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        map = new int[n+1][n+1];
        long[][][] dp = new long[3][n+1][n+1];
        dp[0][0][1] = 1;

        for(int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=1; j<=n; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        // 0 : 가로, 1 : 세로, 2 : 대각
        for(int i=1; i<=n; i++)
            for(int j=3; j<=n; j++) {
                if(map[i][j] == 1) continue;

                dp[0][i][j] = dp[0][i][j-1] + dp[2][i][j-1];

                if(i==0) continue;

                dp[1][i][j] = dp[1][i-1][j] + dp[2][i-1][j];

                if(map[i-1][j] == 1 || map[i][j-1] == 1) continue;

                dp[2][i][j] = dp[0][i-1][j-1] + dp[1][i-1][j-1] + dp[2][i-1][j-1];
            }

        long ans = map[n][n] == 1 ? 0 : dp[0][n][n] + dp[1][n][n] + dp[2][n][n];
        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();

    }
}

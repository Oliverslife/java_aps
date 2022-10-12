package Selected_07_Memoization;

import java.io.*;
import java.util.StringTokenizer;

public class q17069 {

    static int n;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        map = new int[n+1][n+1];
        long[][][] dp = new long[3][n+1][n+1];
        dp[0][1][2] = 1;

        for(int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=1; j<=n; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        // 0 : 가로, 1 : 세로, 2 : 대각
        for(int i=1; i<=n; i++)
            for(int j=3; j<=n; j++) {
                if(map[i][j] == 1) continue;    //막히면 (직전 길에서 가로, 대각선에서 가로로) 못 '온다'
                dp[0][i][j] = dp[0][i][j-1] + dp[2][i][j-1];

                if(i == 1) continue;    //맨 윗줄이라면 세로, 대각선에서 세로로 '오는' 방법이 없으므로
                dp[1][i][j] = dp[1][i-1][j] + dp[2][i-1][j];

                if(map[i-1][j] == 1 || map[i][j-1] == 1) continue;      //대각선으로 올 수 없으므로
                dp[2][i][j] = dp[0][i-1][j-1] + dp[1][i-1][j-1] + dp[2][i-1][j-1];
            }

        long ans = map[n][n] == 1 ? 0 : dp[0][n][n] + dp[1][n][n] + dp[2][n][n];
        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();

    }
}

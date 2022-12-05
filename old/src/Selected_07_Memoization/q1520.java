package Selected_07_Memoization;

import java.io.*;
import java.util.StringTokenizer;

public class q1520 {

    static int n, m;
    static int[][] map, dp;
    static int[][] drc = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
    static boolean in(int r, int c) { return r >= 0 && r < n && c >= 0 && c < m; }
    static int recur(int r, int c) {
        if(r == n-1 && c == m-1)
            return 1;

        if(dp[r][c] != -1)
            return dp[r][c];

        dp[r][c] = 0;
        for(int i=0; i<4; i++) {
            int tr = r + drc[i][0];
            int tc = c + drc[i][1];
            if(in(tr, tc) && map[r][c] > map[tr][tc])
                dp[r][c] += recur(tr, tc);
        }

        return dp[r][c];

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        dp = new int[n][m];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        bw.write(recur(0, 0) + "");
        bw.flush();
        bw.close();
        br.close();


    }
}

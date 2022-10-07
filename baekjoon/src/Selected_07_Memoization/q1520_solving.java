package Selected_07_Memoization;

import java.io.*;
import java.util.StringTokenizer;

public class q1520_solving {

    static int n, m;
    static int[][] map, dp;
    static int[][] drc = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
    static boolean[][] visited;
    static boolean in(int r, int c) { return r >= 0 && r < n && c >= 0 && c < m; }
    static void recur(int r, int c) {
        if(r == n-1 && c == m-1)
            return;

        if(visited[r][c])
            return;

        for(int i=0; i<4; i++) {
            int tr = r + drc[i][0];
            int tc = c + drc[i][1];
            if(in(tr, tc) && map[r][c] > map[tr][tc]) {
                if(dp[tr][tc] != -1)
                    dp[r][c] += dp[tr][tc];
                else {
                    recur(tr, tc);
                    dp[r][c] += dp[tr][tc];
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        dp = new int[n][m];
        visited = new boolean[n][m];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        recur(0, 0);

        bw.write(dp[0][0] + "");
        bw.flush();
        bw.close();
        br.close();


    }
}

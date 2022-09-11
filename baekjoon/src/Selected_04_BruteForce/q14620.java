package Selected_04_BruteForce;

import java.io.*;
import java.util.StringTokenizer;

public class q14620 {
    static int n, ans = Integer.MAX_VALUE;
    static int[][] map;
    static boolean[][] visited;
    static boolean is_Alive(int r, int c) {
        if(r - 1 >=0 && r + 1 < n && c - 1 >=0 && c + 1 < n && !visited[r][c] && !visited[r-1][c] && !visited[r+1][c] && !visited[r][c-1] && !visited[r][c+1])
            return true;
        return false;
    }
    static void dfs(int depth, int cost) {
        if(depth == 3) {
            ans = Math.min(ans, cost);
            return;
        }

        for(int i=0; i<n; i++)
            for(int j=0; j<n; j++)
                if(is_Alive(i, j)) {
                    visited[i][j] = visited[i-1][j] = visited[i+1][j] = visited[i][j-1] = visited[i][j+1] = true;
                    dfs(depth + 1, cost + map[i][j] + map[i-1][j] + map[i+1][j] + map[i][j-1] + map[i][j+1]);
                    visited[i][j] = visited[i-1][j] = visited[i+1][j] = visited[i][j-1] = visited[i][j+1] = false;
                }


    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();

    }
}

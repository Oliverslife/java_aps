package Selected_03_Backtracking;

import java.io.*;
import java.util.StringTokenizer;

public class q10971 {
    static int n, ans = Integer.MAX_VALUE;
    static int[][] map;
    static boolean[] visited;
    static void check(int depth, int origin, int now, int sum) {

        if(depth == n) {
            if(map[now][origin] != 0)
                ans = Math.min(ans, sum + map[now][origin]);
            return;
        }

        for(int i=0; i<n; i++)
            if(!visited[i] && map[now][i] != 0) {
                visited[i] = true;
                check(depth + 1, origin, i, sum + map[now][i]);
                visited[i] = false;
            }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<n; i++) {
            visited[i] = true;
            check(1, i, i, 0);
            visited[i] = false;
        }

        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }
}

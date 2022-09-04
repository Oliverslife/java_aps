package Selected_03_Backtracking;

import java.io.*;
import java.util.StringTokenizer;

public class q14712_solving {
    static int n, m, ans = 0;
    static int[][] map;
    static void dfs(int r, int c, int cnt) {
        if(c == m - 1) {
            c = 0;
            r++;
            dfs(r, c, cnt);
        }
        if(r == n - 1) {

        }

        int y = cnt / m + 1;
        int x = cnt % m + 1;

        if(map[y-1][x] == 1 && map[y][x-1] == 1 && map[y-1][x-1] == 1)
            dfs(cnt + 1);
        else {
            dfs(cnt + 1);
            map[y][x] = 1;
            dfs(cnt + 1);
            map[y][x] = 0;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n+1][m+1];
        dfs(0);
        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }
}

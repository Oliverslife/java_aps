package Selected_03_Backtracking;

import java.io.*;
import java.util.StringTokenizer;

public class q14712 {
    static int n, m, ans = 0;
    static boolean[][] map;
    static void dfs(int r, int c) {

        if(r == n) {
            ans++;
            return;
        }

        int tc = c + 1 == m ? 0 : c + 1;
        int tr = tc == 0 ? r + 1 : r;

        if(r-1>=0 && c-1>=0 &&  map[r-1][c] && map[r][c-1] && map[r-1][c-1]) {
            dfs(tr, tc);
            return;
        }

        map[r][c] = true;
        dfs(tr, tc);

        map[r][c] = false;
        dfs(tr, tc);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new boolean[n][m];
        dfs(0, 0);
        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }
}

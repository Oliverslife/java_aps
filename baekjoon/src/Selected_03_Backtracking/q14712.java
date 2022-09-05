package Selected_03_Backtracking;

import java.io.*;
import java.util.StringTokenizer;

public class q14712 {
    static int n, m, ans = 0;
    static boolean[][] map;
    static void dfs(int r, int c) {
        if(r == n) {
            for(int i=0; i<=n-2; i++)
                for(int j=0; j<=m-2; j++) {
                    if(map[i][j] && map[i][j+1] && map[i+1][j] && map[i+1][j+1])
                        return;
                }
            ans++;
            return;
        }

        int tc = c + 1 == m ? 0 : c + 1;
        int tr = tc == 0 ? r + 1 : r;

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

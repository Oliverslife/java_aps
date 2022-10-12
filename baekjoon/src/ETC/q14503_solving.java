package ETC;

import java.io.*;
import java.util.StringTokenizer;

public class q14503_solving {

    static int n, m, ans = 0;
    static int[][] map;
    static boolean[][] visited;

    static int[][] drc = { {0, -1}, {-1, 0}, {0, 1}, {1, 0} };

    static boolean in(int r, int c) { return r >= 0 && r < n && c >= 0 && c < m; }

    static boolean end(int r, int c, int dir) {

        int tr, tc;
        for(int i=0; i<4; i++) {
            tr = r + drc[i][0];
            tc = c + drc[i][1];
            if(in(tr, tc) && !visited[tr][tc] && map[tr][tc] != 1)
                return false;
        }

        switch (dir) {
            case 0:
                return r+1 > n-1 || map[r+1][c] == 1;
            case 1:
                return c-1 < 0 || map[r][c-1] == 1;
            case 2:
                return r-1 < 0 || map[r-1][c] == 1;
            case 3:
                return c+1 > m-1 || map[r][c+1] == 1;
            default:
                return false;
        }

    }

    static void dfs(int r, int c, int dir) {

        if(!visited[r][c]) {
            visited[r][c] = true;
            ans++;
        }

        if(end(r, c, dir))
            return;

        boolean checker = true;
        int tr, tc, cnt = 0;
        for(int i=dir; cnt++ != 4; i = i-1 < 0 ? 3 : i-1) {
            tr = r + drc[i][0];
            tc = c + drc[i][1];
            if(in(tr, tc) && !visited[tr][tc] && map[tr][tc] != 1) {
                checker = false;
                dfs(tr, tc, i);
                return;
            }
        }

        if(checker) {
            switch (dir) {
                case 0:
                    dfs(r+1, c, dir);
                    break;
                case 1:
                    dfs(r, c-1, dir);
                    break;
                case 2:
                    dfs(r-1, c, dir);
                    break;
                case 3:
                    dfs(r, c+1, dir);
                    break;
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
        visited = new boolean[n][m];

        st = new StringTokenizer(br.readLine());
        int start_r = Integer.parseInt(st.nextToken()) - 1;
        int start_c = Integer.parseInt(st.nextToken()) - 1;
        int start_dir = Integer.parseInt(st.nextToken());     // 0 : 북쪽, 1 : 동쪽, 2 : 남쪽, 3 : 서쪽

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        dfs(start_r, start_c, start_dir);

        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();

    }
}

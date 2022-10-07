package Selected_05_GraphTraversal;

import java.util.Scanner;

public class q1012_dfs {

    static int m, n, k;
    static int[][] map;
    static int[][] drc = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
    static boolean in(int r, int c) { return r >= 0 && r < n && c >= 0 && c < m; }
    static boolean[][] visited;
    static void dfs(int r, int c) {

        visited[r][c] = true;

        int tr, tc;
        for(int i=0; i<4; i++) {
            tr = r + drc[i][0];
            tc = c + drc[i][1];
            if(in(tr, tc) && !visited[tr][tc] && map[tr][tc] == 1)
                dfs(tr, tc);
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int t = sc.nextInt();
        int cnt, r, c;

        while(t-- > 0) {

            cnt = 0;
            m = sc.nextInt();
            n = sc.nextInt();
            k = sc.nextInt();
            map = new int[n][m];
            visited = new boolean[n][m];
            while(k-- > 0) {
                c = sc.nextInt();
                r = sc.nextInt();
                map[r][c] = 1;
            }

            for(int i=0; i<n; i++)
                for(int j=0; j<m; j++)
                    if(map[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j);
                        cnt++;
                    }

            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
        sc.close();
    }
}

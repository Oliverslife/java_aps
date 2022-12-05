package Selected_04_BruteForce;

import java.io.*;
import java.util.StringTokenizer;

public class q14500 {
    // 잘 생각해보면 테트로미노는 상하좌우 완전탐색. 'ㅗ'모양의 경우만 처리해주면 됨.

    static int n, m, ans = Integer.MIN_VALUE, maxval = 0;
    static int[][] data;
    static int[][] drc = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
    static boolean[][] visited;
    static boolean in(int r, int c) { return r >= 0 && r < n && c >= 0 && c < m; }
    static class Point {
        int r, c;
        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    static void dfs(Point p, int cnt, int sum) {

        if(ans >= sum + (maxval * (4 - cnt)))   //이런 방법이...!
            return;

        if(cnt == 4) {
            ans = Math.max(ans, sum);
            return;
        }

        int tr, tc;
        for(int i=0; i<4; i++) {
            tr = p.r + drc[i][0];
            tc = p.c + drc[i][1];

            if(in(tr, tc) && !visited[tr][tc]) {

                visited[tr][tc] = true;
                dfs(new Point(tr, tc), cnt + 1, sum + data[tr][tc]);
//                dfs(p, cnt + 1, sum + data[tr][tc]);
                visited[tr][tc] = false;

                if(cnt == 2) {  //'ㅗ' 모양 고려하여 두 번째 칸(현재 칸)에서 재검색
                    visited[tr][tc] = true;
                    dfs(p, cnt + 1, sum + data[tr][tc]);
                    visited[tr][tc] = false;
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
        data = new int[n][m];
        visited = new boolean[n][m];

        int tmp;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                tmp = Integer.parseInt(st.nextToken());
                data[i][j] = tmp;
                maxval = Math.max(maxval, tmp);
            }
        }

        for(int i=0; i<n; i++)
            for(int j=0; j<m; j++) {
                visited[i][j] = true;
                dfs(new Point(i, j), 1, data[i][j]);
                visited[i][j] = false;
            }

        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }
}

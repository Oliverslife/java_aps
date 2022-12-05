package Selected_05_GraphTraversal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class q1194 {
    static int n, m;
    static boolean in(int r, int c) { return r >= 0 && r < n && c >= 0 && c < m; }
    static class Point {
        int r, c, step, d;
        public Point(int r, int c, int step, int d) {
            this.r = r;
            this.c = c;
            this.step = step;
            this.d = d;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[][] drc = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
        char[][] map = new char[n][m];
        boolean[][][] visited = new boolean[1<<6][n][m];

        Point start = new Point(0, 0, 0, 0);
        char[] tmp;
        for(int i=0; i<n; i++) {
            tmp = br.readLine().toCharArray();
            for(int j=0; j<m; j++) {
                map[i][j] = tmp[j];
                if(tmp[j] == '0')
                    start = new Point(i, j, 0, 0);
            }
        }

        Queue<Point> q = new ArrayDeque<>();
        q.offer(start);
        int tr, tc, ans = Integer.MAX_VALUE;
        Point p;

        while(!q.isEmpty()) {
            p = q.poll();
            if(map[p.r][p.c] == '1') {
                ans = p.step;
                break;
            }

            for(int i=0; i<4; i++) {
                tr = p.r + drc[i][0];
                tc = p.c + drc[i][1];
                if(in(tr, tc) && !visited[p.d][tr][tc]) {
                    if(map[tr][tc] == '.' || map[tr][tc] == '0' || map[tr][tc] == '1') {
                        visited[p.d][tr][tc] = true;
                        q.offer(new Point(tr, tc, p.step + 1, p.d));
                    }
                    if(map[tr][tc] >= 'a' && map[tr][tc] <= 'f') {
                        visited[p.d | 1<<(map[tr][tc]-'a')][tr][tc] = true;
                        q.offer(new Point(tr, tc, p.step + 1, p.d | 1<<(map[tr][tc]-'a')));
                    }
                    if(map[tr][tc] >= 'A' && map[tr][tc] <= 'F' && (p.d & 1<<(map[tr][tc]-'A')) > 0) {
                        visited[p.d][tr][tc] = true;
                        q.offer(new Point(tr, tc, p.step + 1, p.d));
                    }
                }
            }
        }
        ans = ans == Integer.MAX_VALUE ? -1 : ans;
        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();

    }

}

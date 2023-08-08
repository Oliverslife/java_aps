package Selected_05_GraphTraversal;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class q14940 {

    static int n, m;

    static class Point {
        int r, c;
        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static boolean in(int r, int c) { return r >= 0 && r < n && c >= 0 && c < m; }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];

        int tmp;
        Point target = new Point(0, 0);
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                tmp = Integer.parseInt(st.nextToken());
                map[i][j] = tmp;
                if(tmp == 2)
                    target = new Point(i, j);
            }
        }

        boolean[][] visited = new boolean[n][m];
        visited[target.r][target.c] = true;
        map[target.r][target.c] = 0;
        Queue<Point> q = new ArrayDeque<>();
        q.offer(target);
        int[][] drc = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
        int tr, tc;

        Point p;
        while(!q.isEmpty()) {
            p = q.poll();

            for(int i=0; i<4; i++) {
                tr = p.r + drc[i][0];
                tc = p.c + drc[i][1];

                if(in(tr, tc) && !visited[tr][tc] && map[tr][tc] == 1) {
                    visited[tr][tc] = true;
                    map[tr][tc] = map[p.r][p.c] + 1;
                    q.offer(new Point(tr, tc));
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<n; i++) {
            for (int j = 0; j < m; j++) {
                if(!visited[i][j] && map[i][j] == 1)
                    map[i][j] = -1;
                sb.append(map[i][j] + " ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}

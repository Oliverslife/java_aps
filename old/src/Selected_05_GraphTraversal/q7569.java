package Selected_05_GraphTraversal;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class q7569 {

    static int m, n, h;

    static class Point {
        int r, c, h;
        public Point(int h, int r, int c) {
            this.h = h;
            this.r = r;
            this.c = c;
        }
    }

    static boolean is_in(int a, int r, int c) {
        if(r >= 0 && r < n && c >= 0 && c < m && a >= 0 && a < h)
            return true;
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] dhrc = { {1, 0, 0}, {-1, 0, 0}, {0, 1, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1} };
        int th, tr, tc;

        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        int[][][] box = new int[h][n][m];
        boolean[][][] visited = new boolean[h][n][m];
        Queue<Point> q = new ArrayDeque<>();

        int tmp;
        for(int i=0; i<h; i++)
            for(int j=0; j<n; j++) {
                st = new StringTokenizer(br.readLine());
                for(int k=0; k<m; k++) {
                    tmp = Integer.parseInt(st.nextToken());
                    box[i][j][k] = tmp;
                    if(tmp == 1) {
                        q.offer(new Point(i, j, k));
                        visited[i][j][k] = true;
                    }
                    else if(tmp == -1)
                        visited[i][j][k] = true;
                }
            }

        while(!q.isEmpty()) {
            Point p = q.poll();

            for(int i=0; i<6; i++) {
                th = p.h + dhrc[i][0];
                tr = p.r + dhrc[i][1];
                tc = p.c + dhrc[i][2];
                if(is_in(th, tr, tc) && !visited[th][tr][tc]) {
                    q.offer(new Point(th, tr, tc));
                    visited[th][tr][tc] = true;
                    box[th][tr][tc] = box[p.h][p.r][p.c] + 1;
                }
            }
        }

        boolean zero = false;
        int max = 0;
        loop:
        for(int i=0; i<h; i++)
            for(int j=0; j<n; j++)
                for(int k=0; k<m; k++) {
                    if (!visited[i][j][k]) {
                        zero = true;
                        break;
                    }
                    max = Math.max(max, box[i][j][k]);
                }

        int ans = zero ? -1 : max - 1;

        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }
}

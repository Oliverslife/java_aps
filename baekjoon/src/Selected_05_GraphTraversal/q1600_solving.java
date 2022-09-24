package Selected_05_GraphTraversal;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class q1600_solving {

    static int w, h;

    static boolean in(int r, int c) { return r >= 0 && r < h && c >= 0 && c < w; }

    static class Point {
        int r, c;
        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int k = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        int[][] map = new int[h][w];
        boolean[][] visited = new boolean[h][w];

        for(int i=0; i<h; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<w; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        int[][] drc = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
        int[][] jump = { {-2, -1}, {-2, 1}, {2, -1}, {2, 1}, {-1, 2}, {1, 2}, {-1, -2}, {1, -2} };
        int tr, tc;
        Point p;
        boolean jumped;

        Queue<Point> q = new ArrayDeque<>();
        q.offer(new Point(h-1, w-1));
        visited[0][0] = true;

        while(!q.isEmpty()) {
            p = q.poll();
            jumped = false;

            //점프를 마구 사용해버리면 꼭 필요할 때에 점프할 수 없군요?
            for(int i=0; i<2; i++) {
                tr = p.r + jump[i][0];
                tc = p.c + jump[i][1];
                if(in(tr, tc) && !visited[tr][tc] && map[tr][tc] != 1 && k > 0) {
                    visited[tr][tc] = true;
                    q.offer(new Point(tr, tc));
                    map[tr][tc] = map[p.r][p.c] + 1;
                    jumped = true;
                }
            }

            k -= jumped ? 1 : 0;

            for(int i=0; i<4; i++) {
                tr = p.r + drc[i][0];
                tc = p.c + drc[i][1];
                if(in(tr, tc) && !visited[tr][tc] && map[tr][tc] != 1) {
                    visited[tr][tc] = true;
                    q.offer(new Point(tr, tc));
                    map[tr][tc] = map[p.r][p.c] + 1;
                }
            }

        }

        int ans = map[h-1][w-1] == 0 ? -1 : map[h-1][w-1];
        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();

    }
}

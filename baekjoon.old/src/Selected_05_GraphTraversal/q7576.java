package Selected_05_GraphTraversal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class q7576 {

    static int n, m;

    static class Point {
        int r, c;
        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static boolean is_in(int r, int c) {
        if(r >= 0 && r < m && c >= 0 && c < n)
            return true;
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Point> list = new ArrayList<>();
        int ans = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[][] map = new int[m][n];
        boolean[][] visited = new boolean[m][n];

        int tmp;
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                tmp = Integer.parseInt(st.nextToken());
                map[i][j] = tmp;
                if(tmp == 1) {
                    list.add(new Point(i, j));
                    visited[i][j] = true;
                }

                if(tmp == -1)
                    visited[i][j] = true;		//미리 막아두기
            }
        }

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        int tr, tc;

        Queue<Point> q = new ArrayDeque<>();
        for(int i=0; i<list.size(); i++)
            q.offer(new Point(list.get(i).r, list.get(i).c));

        while(!q.isEmpty()) {
            Point p = q.poll();

            for(int j=0; j<4; j++) {
                tr = p.r + dr[j];
                tc = p.c + dc[j];
                if(is_in(tr, tc) && !visited[tr][tc]) {
                    q.offer(new Point(tr, tc));
                    visited[tr][tc] = true;
                    map[tr][tc] = map[p.r][p.c] + 1;
                }
            }
        }

        boolean zero = false;
        int max = 0;

        loop:
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(map[i][j] == 0) {
                    zero = true;
                    break;
                }
                max = Math.max(max, map[i][j]);
            }
        }
        ans = zero ? -1 : max - 1;

        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();

    }

}
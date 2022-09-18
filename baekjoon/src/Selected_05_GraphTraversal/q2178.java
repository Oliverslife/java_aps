package Selected_05_GraphTraversal;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class q2178 {
    static int n, m;
    static class Point {
        int r, c;
        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    static boolean is_in(int r, int c) {
        if(r >= 0 && r < n && c >= 0 && c < m)
            return true;
        return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];

        for(int i=0; i<n; i++) {
            char[] tmp = br.readLine().toCharArray();
            for(int j=0; j<m; j++)
                map[i][j] = Character.getNumericValue(tmp[j]);
        }
        //입력데이터 처리

        int tr, tc;     //임시 좌표

        Queue<Point> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];
        q.offer(new Point(0, 0));

        while(!q.isEmpty()) {
            Point tmp = q.poll();
            visited[tmp.r][tmp.c] = true;

            for(int i=0; i<4; i++) {
               tr = tmp.r + dr[i];
                tc = tmp.c + dc[i];
                if(is_in(tr, tc) && !visited[tr][tc] && map[tr][tc] == 1) {
                    visited[tr][tc] = true;
                    map[tr][tc] = map[tmp.r][tmp.c] + 1;
                    q.offer(new Point(tr, tc));
                }
            }
        }

        bw.write(map[n-1][m-1] + "");
        bw.flush();
        bw.close();
        br.close();

    }
}

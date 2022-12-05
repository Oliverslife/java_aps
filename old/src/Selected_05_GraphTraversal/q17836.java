package Selected_05_GraphTraversal;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class q17836 {
    static int n, m;

    static class Point {
        int r, c;
        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static boolean is_in(int r, int c) {
        return r >= 0 && c >= 0 && r < n && c < m;
    }

    static int dist(Point A, Point B) {
        return Math.abs(A.r - B.r) + Math.abs(A.c - B.c);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        int[][] drc = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };

        int tmp;
        Point sword = new Point(n-1, m-1);
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                tmp = Integer.parseInt(st.nextToken());
                map[i][j] = tmp;
                if(tmp == 2)
                    sword = new Point(i, j);
            }
        }

        Queue<Point> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];
        q.offer(new Point(0, 0));
        visited[0][0] = true;

        Point p;
        int tr, tc;
        boolean get = false;
        while(!q.isEmpty()) {
            p = q.poll();

            for(int i=0; i<4; i++) {
                tr = p.r + drc[i][0];
                tc = p.c + drc[i][1];
                if(is_in(tr, tc) && !visited[tr][tc] && map[tr][tc] != 1) {
                    visited[tr][tc] = true;
                    map[tr][tc] = map[p.r][p.c] + 1;
                    q.offer(new Point(tr, tc));
                    if(sword.r == tr && sword.c == tc)
                        get = true;
                }
            }
        }

//        for(int i=0; i<n; i++) {
//            for(int j=0; j<m; j++) {
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }

        int bruteway = map[n-1][m-1] == 0 ? Integer.MAX_VALUE : map[n-1][m-1];      //도달하지 못하면 max_value로 t시간 안에 도달하지 못하게 함
        int swordway = !get ? Integer.MAX_VALUE : map[sword.r][sword.c] + dist(sword, new Point(n-1, m-1));   //전설의 명검 그람을 얻지 못하면 max_value 처리
        int len = Math.min(bruteway, swordway);     //최적 거리

        StringBuilder sb = new StringBuilder();
        if(len > t)
            sb.append("Fail");
        else
            sb.append(len);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }
}

package Selected_05_GraphTraversal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class q2573 {

    static int n, m;
    static boolean in(int r, int c) { return r >= 0 && r < n && c >= 0 && c < m; }
    static class Point {
        int r, c;
        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        Queue<Point> q = new ArrayDeque<>();
        Map<Point, Integer> record = new HashMap<>();
        int[][] drc = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
        int year = 0, ans = 0;
        boolean[][] visited;

        while(true) {

            int island = 0;
            visited = new boolean[n][m];

            for(int i=0; i<n; i++) {
                for(int j=0; j<m; j++) {
                    if(map[i][j] != 0 && !visited[i][j]) {

                        record.clear();
                        q.offer(new Point(i, j));
                        visited[i][j] = true;

                        while(!q.isEmpty()) {
                            Point p = q.poll();
                            int search = 0;

                            for(int k=0; k<4; k++) {
                                int tr = p.r + drc[k][0];
                                int tc = p.c + drc[k][1];
                                if(in(tr, tc)) {
                                    if(!visited[tr][tc] && map[tr][tc] != 0) {
                                        visited[tr][tc] = true;
                                        q.offer(new Point(tr, tc));
                                    }
                                    if(map[tr][tc] == 0)
                                        search++;
                                }
                            }
                            record.put(new Point(p.r, p.c), search);
                        }
                        island++;

                    }
                }
            }

            if(island == 1) {
                for(Map.Entry<Point, Integer> e : record.entrySet()) {
                    Point p = e.getKey();
                    map[p.r][p.c] -= map[p.r][p.c] - e.getValue() < 0 ? map[p.r][p.c] : e.getValue();
                }
                year++;
            }
            else if(island > 1)
                break;
            else {
                year = 0;
                break;
            }

        }
        bw.write(year + "");
        bw.flush();
        bw.close();
        br.close();
    }
}

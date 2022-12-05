package Selected_05_GraphTraversal;

import java.io.*;
import java.util.*;

public class q16932 {

    static int n, m;

    static class Point {
        int r, c;
        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static boolean in(int r, int c) { return r < n && c < m && r >= 0 && c >= 0; }

    public static void main(String[] args) throws IOException {
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

        int[][] drc = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
        boolean[][] visited = new boolean[n][m];
        Queue<Point> q = new ArrayDeque<>();
        int idx = 2, cnt;
        Map<Integer, Integer> data = new HashMap<>();

        //indexing
        for(int i=0; i<n; i++)
            for(int j=0; j<m; j++)
                if(map[i][j] != 0 && !visited[i][j]) {
                    visited[i][j] = true;
                    map[i][j] = idx;
                    q.offer(new Point(i, j));

                    cnt = 0;
                    while(!q.isEmpty()) {
                        Point p = q.poll();
                        cnt++;

                        for(int k=0; k<4; k++) {
                            int tr = p.r + drc[k][0];
                            int tc = p.c + drc[k][1];
                            if(in(tr, tc) && !visited[tr][tc] && map[tr][tc] != 0) {
                                visited[tr][tc] = true;
                                map[tr][tc] = idx;
                                q.offer(new Point(tr, tc));
                            }
                        }
                    }
                    data.put(idx, cnt);
                    idx++;
                }

        int ans = Integer.MIN_VALUE;
        Set<Integer> selected = new HashSet<>();
        for(int i=0; i<n; i++)
            for(int j=0; j<m; j++)
                if(map[i][j] == 0) {
                    cnt = 0;

                    for(int k=0; k<4; k++) {
                        int tr = i + drc[k][0];
                        int tc = j + drc[k][1];
                        if(in(tr, tc) && map[tr][tc] != 0)
                            selected.add(map[tr][tc]);
                    }
                    for(int x : selected)
                        cnt += data.get(x);
                    selected.clear();

                    ans = Math.max(ans, cnt + 1);


                }

        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();

    }
}

package Selected_05_GraphTraversal;

import java.io.*;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class q2667 {
    static int n;
    static class Point {
        int r, c;
        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static boolean is_in(int r, int c) {
        if(r >= 0 && r < n && c >= 0 && c < n)
            return true;
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];

        char[] tmp;
        for(int i=0; i<n; i++) {
            tmp = br.readLine().toCharArray();
            for(int j=0; j<n; j++)
                map[i][j] = Character.getNumericValue(tmp[j]);
        }

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        Queue<Integer> ans = new PriorityQueue<>();

        for(int i=0; i<n; i++)
            for(int j=0; j<n; j++) {
                if(map[i][j] == 0)
                    continue;

                int cnt = 0;

                Queue<Point> q = new ArrayDeque<>();
                q.offer(new Point(i, j));

                while(!q.isEmpty()) {
                    Point p = q.poll();
                    map[i][j] = 0;
                    cnt++;

                    for(int k=0; k<4; k++) {
                        int tr = p.r + dr[k];
                        int tc = p.c + dc[k];
                        if(is_in(tr, tc) && map[tr][tc] == 1) { //값이 1인 위치만 확인하므로 방문체크 불필요
                            map[tr][tc] = 0;
                            q.offer(new Point(tr, tc));
                        }
                    }
                }

                ans.offer(cnt);
            }

        StringBuilder sb = new StringBuilder();
        sb.append(ans.size() + "\n");
        while(!ans.isEmpty())
            sb.append(ans.poll() + "\n");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }
}

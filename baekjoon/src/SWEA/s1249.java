package SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class s1249 {

    static int n;

    static class Point implements Comparable<Point> {
        int r, c, ans;
        public Point(int r, int c, int ans) {
            this.r = r;
            this.c = c;
            this.ans = ans;
        }

        @Override
        public int compareTo(Point o) {
            return this.ans - o.ans;
        }
    }

    static boolean in(int r, int c) { return r >= 0 && c >= 0 && r < n && c < n; }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        char[] ch;
        int[][] map;
        int[][] drc = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
        int tr, tc, ans;

        boolean[][] visited;
        Queue<Point> pq;
        Point p;


        int t = Integer.parseInt(br.readLine());
        for(int testc=1; testc<=t; testc++) {

            n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            visited = new boolean[n][n];

            for(int i=0; i<n; i++) {
                ch = br.readLine().toCharArray();
                for(int j=0; j<n; j++)
                    map[i][j] = Character.getNumericValue(ch[j]);
            }

            pq = new PriorityQueue<>();
            pq.offer(new Point(0, 0, map[0][0]));
            visited[0][0] = true;
            ans = Integer.MAX_VALUE;

            while(!pq.isEmpty()) {
                p = pq.poll();

                if(p.r == n-1 && p.c == n-1) {
                    ans = p.ans;
                    break;
                }


                for(int i=0; i<4; i++) {
                    tr = p.r + drc[i][0];
                    tc = p.c + drc[i][1];
                    if(!in(tr, tc) || visited[tr][tc])
                        continue;
                    visited[tr][tc] = true;
                    pq.offer(new Point(tr, tc, p.ans + map[tr][tc]));
                }
            }

            sb.append("#" + testc + " " + ans + "\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}

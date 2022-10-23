package Selected_05_GraphTraversal;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class q10026 {

    static int N;

    static class Point {
        int r, c;
        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static boolean in(int r, int c) { return r >= 0 && c >= 0 && r < N && c < N; }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        char[][] data = new char[N][N];
        for(int i=0; i<N; i++)
            data[i] = sc.next().toCharArray();
        sc.close();

        int ans1 = 0;
        int ans2 = 0;

        int[][] drc = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
        boolean[][] visited = new boolean[N][N];
        Queue<Point> q = new ArrayDeque<>();
        Point p;
        int tr, tc;

        for(int i=0; i<N; i++)
            for(int j=0; j<N; j++)
                if(!visited[i][j]) {
                    visited[i][j] = true;
                    q.offer(new Point(i, j));
                    while(!q.isEmpty()) {
                        p = q.poll();
                        for(int k=0; k<4; k++) {
                            tr = p.r + drc[k][0];
                            tc = p.c + drc[k][1];
                            if(in(tr, tc) && !visited[tr][tc] && data[tr][tc] == data[p.r][p.c]) {
                                visited[tr][tc] = true;
                                q.offer(new Point(tr, tc));
                            }
                        }
                    }
                    ans1++;
                }

        for(int i=0; i<N; i++)
            for(int j=0; j<N; j++)
                if(data[i][j] == 'R')
                    data[i][j] = 'G';

        visited = new boolean[N][N];
        for(int i=0; i<N; i++)
            for(int j=0; j<N; j++)
                if(!visited[i][j]) {
                    visited[i][j] = true;
                    q.offer(new Point(i, j));
                    while(!q.isEmpty()) {
                        p = q.poll();
                        for(int k=0; k<4; k++) {
                            tr = p.r + drc[k][0];
                            tc = p.c + drc[k][1];
                            if(in(tr, tc) && !visited[tr][tc] && data[tr][tc] == data[p.r][p.c]) {
                                visited[tr][tc] = true;
                                q.offer(new Point(tr, tc));
                            }
                        }
                    }
                    ans2++;
                }
        System.out.print(ans1 + " " + ans2);
    }
}

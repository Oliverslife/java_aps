package Selected_05_GraphTraversal;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class q16236_solving {

    static int N;
    static int[][] map;
    static int[][] drc = { {-1, 0}, {0, -1}, {1, 0}, {0, 1} };
    static boolean in(int r, int c) { return r >= 0 && c >= 0 && r < N && c < N; }
    static class Point implements Comparable<Point> {
        int r, c, sec;
        public Point(int r, int c, int sec) {
            this.r = r;
            this.c = c;
            this.sec = sec;
        }

        @Override
        public int compareTo(Point o) {
            if(this.sec == o.sec) {
                if(this.r == o.r)
                    return this.c - o.c;
                return this.r - o.r;
            }
            return this.sec - o.sec;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];

        int tmp;
        Point start = new Point(-1, -1, -1);
        for(int i=0; i<N; i++)
            for(int j=0; j<N; j++) {
                tmp = sc.nextInt();
                map[i][j] = tmp;
                if(tmp == 9) {
                    start = new Point(i, j, 0);
                    map[i][j] = 0;
                }
            }
        sc.close();

        Queue<Point> q = new PriorityQueue<>();
        boolean[][] visited;
        boolean help = false, eat;
        int tr, tc, shark = 2, stack = 0, ans = 0;
        while(!help) {
            eat = false;
            visited = new boolean[N][N];
            visited[start.r][start.c] = true;
            q.offer(start);

            bfs:
            while(!q.isEmpty()) {
                Point p = q.poll();
                for(int i=0; i<4; i++) {
                    tr = p.r + drc[i][0];
                    tc = p.c + drc[i][1];
                    if(in(tr, tc) && !visited[tr][tc] && map[tr][tc] <= shark) {
                        if(map[tr][tc] == shark || map[tr][tc] == 0) {
                            visited[tr][tc] = true;
                            q.offer(new Point(tr, tc, p.sec + 1));
                        }
                        else {
                            start = new Point(tr, tc, 0);
                            map[tr][tc] = 0;
                            eat = true;
                            stack++;
                            if(shark == stack) {
                                shark++;
                                stack = 0;
                            }
                            ans += p.sec + 1;
                            break bfs;
                        }
                    }
                }
            }
            q.clear();
            if(!eat)
                help = true;
        }

        System.out.print(ans);

    }
}

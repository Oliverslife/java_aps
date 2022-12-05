package Selected_05_GraphTraversal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class q16234 {

    static int n;

    static class Point {
        int r, c;
        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static boolean is_in(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < n;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][n];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        boolean open = true, moved = false;
        boolean[][] visited;
        int tr, tc, tmp, ans = 0;
        int[][] drc = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
        Queue<Point> q = new ArrayDeque<>();
        Stack<Point> s = new Stack<>();
        Point p;

        while(open) {

            visited = new boolean[n][n];
            moved = false;

            for(int i=0; i<n; i++)
                for(int j=0; j<n; j++)
                    if(!visited[i][j]) {

                        tmp = 0;
                        q.offer(new Point(i, j));
                        visited[i][j] = true;

                        while(!q.isEmpty()) {
                            p = q.poll();
                            s.push(p);
                            tmp += map[p.r][p.c];

                            for(int k=0; k<4; k++) {
                                tr = p.r + drc[k][0];
                                tc = p.c + drc[k][1];

                                if(is_in(tr, tc) && !visited[tr][tc] && Math.abs(map[p.r][p.c] - map[tr][tc]) >= l && Math.abs(map[p.r][p.c] - map[tr][tc]) <= r) {
                                    visited[tr][tc] = true;
                                    q.offer(new Point(tr, tc));

                                }
                            }
                        }
                        if(s.size() >= 2)
                            moved = true;

                        tmp = tmp / s.size();
                        while(!s.isEmpty()) {
                            p = s.pop();
                            map[p.r][p.c] = tmp;
                        }
                    }

            if(moved)
                ans++;
            if(!moved)
                open = false;
        }
//		for(int i=0; i<n; i++) {
//			for(int j=0; j<n; j++)
//				System.out.print(map[i][j] + " ");
//			System.out.println();
//		}
        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();

    }

}

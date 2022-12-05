package SWEA;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class s1949_dfs {

    static int n, k, ans;
    static int[][] map;
    static int[][] drc = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
    static boolean[][] visited;
    static boolean is_in(int r, int c) { return r >= 0 && r < n && c >= 0 && c < n; }

    static class Point {
        int r, c;
        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static void dfs(Point p, int len, boolean used) {
//		visited[r][c] = true;		여기서 방문처리 해주면 안되겠다.
        ans = len > ans ? len : ans;

        for(int i=0; i<4; i++) {		// 2. 반드시 높은 지형에서 낮은 지형으로 가로 또는 세로 어쩌고 저쩌고
            int tr = p.r + drc[i][0];
            int tc = p.c + drc[i][1];
            if(is_in(tr, tc) && !visited[tr][tc]) {
                if(map[p.r][p.c] > map[tr][tc]) {
                    visited[tr][tc] = true;
                    dfs(new Point(tr, tc), len + 1, used);
                    visited[tr][tc] = false;
                }
                else if(!used) {		//드릴을 사용하지 않은 상태에서 높이가 적절하지 않을 경우
                    for(int j=1; j<=k; j++) {
                        if(map[tr][tc] - j >= 0 && map[p.r][p.c] > map[tr][tc] - j) {
                            visited[tr][tc] = true;
                            map[tr][tc] -= j;
                            dfs(new Point(tr, tc), len + 1, true);		//드릴 사용함(true)
                            visited[tr][tc] = false;
                            map[tr][tc] += j;
                        }
                    }
                }
            }
        }

    }

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int tmp, max;
        Queue<Point> top = new ArrayDeque<>();
        Point p;

        for(int tc=1; tc<=t; tc++) {

            ans = 0;
            n = sc.nextInt();
            k = sc.nextInt();
            map = new int[n][n];

            max = Integer.MIN_VALUE;
            for(int i=0; i<n; i++)
                for(int j=0; j<n; j++) {
                    tmp = sc.nextInt();
                    map[i][j] = tmp;
                    if(tmp > max) {		// 1. 등산로는 가장 높은 봉우리에서 시작해야 한다.
                        max = tmp;		// 아니 이걸 빠뜨려서 하루를 태워?????????????
                        top.clear();
                        top.offer(new Point(i, j));
                    }
                    else if(tmp == max)
                        top.offer(new Point(i, j));
                }

            while(!top.isEmpty()) {
                visited = new boolean[n][n];
                p = top.poll();
                visited[p.r][p.c] = true;	//여기서 방문처리 해줘야겠다.
                dfs(p, 1, false);
            }

            sb.append("#" + tc + " " + ans + "\n");
        }
        sc.close();
        System.out.print(sb);

    }
}

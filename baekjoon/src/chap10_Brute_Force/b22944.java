package chap10_Brute_Force;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class b22944 {

    static int N, H, D, start_r, start_c, end_r, end_c, dist, toUmbrella, ans = Integer.MAX_VALUE;
    static char[][] map;
    static boolean[] visited;
    static List<int[]> umbrellas = new ArrayList<>();
    static void DFS(int depth, int[] point, int hp, int shield, int step) {

        dist = Math.abs(point[0] - end_r) + Math.abs(point[1] - end_c);

        if (dist < hp + shield) {
            ans = step + dist < ans ? step + dist : ans;
            return;
        }

        if (step + dist >= ans || depth == umbrellas.size()) return;

        for (int i=0; i<umbrellas.size(); i++) {
            toUmbrella = Math.abs(point[0] - umbrellas.get(i)[0]) + Math.abs(point[1] - umbrellas.get(i)[1]);
            if (visited[i] || hp + shield <= toUmbrella) continue;
            visited[i] = true;
            DFS(depth + 1, umbrellas.get(i), hp - (toUmbrella < shield ? 0 : toUmbrella - shield), D, step + toUmbrella);
            visited[i] = false;

        }

    }

    public static void main(String[] args) {

        String str;
        char ch;

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        H = sc.nextInt();
        D = sc.nextInt();
        map = new char[N][N];

        for (int i=0; i<N; i++) {
            str = sc.next();
            for (int j = 0; j < N; j++) {
                ch = str.charAt(j);
                map[i][j] = ch;

                if (ch == 'S') {
                    start_r = i;
                    start_c = j;
                } else if (ch == 'E') {
                    end_r = i;
                    end_c = j;
                } else if (ch == 'U')
                    umbrellas.add(new int[]{i, j});

            }
        }

        visited = new boolean[umbrellas.size()];
        DFS(0, new int[]{start_r, start_c}, H + 1, 0, 0);
        ans = ans == Integer.MAX_VALUE ? -1 : ans;
        System.out.println(ans);

    }
}

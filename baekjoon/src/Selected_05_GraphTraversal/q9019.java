package Selected_05_GraphTraversal;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class q9019 {

    static class Data {
        String cmd;
        int val;
        public Data(String cmd, int val) {
            this.cmd = cmd;
            this.val = val;
        }
    }

    static int cal(int val, char cmd) {
        switch (cmd) {
            case 'D':
                return val * 2 % 10000;
            case 'S':
                return val != 0 ? val - 1 : 9999;
            case 'L':
                return val % 1000 * 10 + (val / 1000);
            case 'R':
                return val / 10 + (val % 10 * 1000);
        }
        return 0;
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        int A, B, D, S, L, R;
        boolean[] visited;
        Queue<Data> q = new ArrayDeque<>();

        while(T-- > 0) {
            A = sc.nextInt();
            B = sc.nextInt();
            visited = new boolean[10000];

            visited[A] = true;
            q.offer(new Data("", A));
            while(!q.isEmpty()) {
                Data d = q.poll();
                if(d.val == B) {
                    sb.append(d.cmd + "\n");
                    break;
                }

                D = cal(d.val, 'D');
                S = cal(d.val, 'S');
                L = cal(d.val, 'L');
                R = cal(d.val, 'R');

                if(!visited[D]) {
                    visited[D] = true;
                    q.offer(new Data(d.cmd + "D", D));
                }

                if(!visited[S]) {
                    visited[S] = true;
                    q.offer(new Data(d.cmd + "S", S));
                }

                if(!visited[L]) {
                    visited[L] = true;
                    q.offer(new Data(d.cmd + "L", L));
                }

                if(!visited[R]) {
                    visited[R] = true;
                    q.offer(new Data(d.cmd + "R", R));
                }
            }
            q.clear();

        }
        sc.close();
        System.out.print(sb);
    }
}

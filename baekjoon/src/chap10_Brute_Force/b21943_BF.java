package chap10_Brute_Force;

import java.util.Scanner;
// 풀이중
public class b21943_BF {

    static int N, P, Q, ans = Integer.MIN_VALUE;
    static int[] num, selected;
    static char[] ops;
    static boolean[] visited;

    static void DFS1(int depth) {
        if (depth == N)
            DFS2(0);

        for (int i=0; i<N; i++) {
            if (visited[i]) continue;
            selected[depth] = num[i];
            visited[i] = true;
            DFS1(depth + 1);
            visited[i] = false;
        }
    }

    static void DFS2(int depth) {
        if (depth == N - 1)
            DFS3(0, selected[0]);

        if (P > 0) {
            P--;
            ops[depth] = '+';
            DFS2(depth + 1);
            P++;
        }

        if (Q > 0) {
            Q--;
            ops[depth] = '*';
            DFS2(depth + 1);
            Q++;
        }
    }

    static void DFS3(int depth, int total) {
        if (depth == N - 1) {
            ans = Math.max(ans, total);
            return;
        }

        DFS3(depth + 1, calculate(total, selected[depth + 1], ops[depth]));

        if (depth < ops.length - 1) {
            int tmp = calculate(selected[depth + 1], selected[depth + 2], ops[depth + 1]);
            DFS3(depth + 2, calculate(total, tmp, ops[depth]));
        }

    }

    static int calculate(int x, int y, char op) {
        int answer;

        if (op == '+')
            answer = x + y;
        else
            answer = x * y;

        return answer;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        num = new int[N];
        selected = new int[N];
        ops = new char[N - 1];
        visited = new boolean[N];

        for (int i=0; i<N; i++)
            num[i] = sc.nextInt();

        P = sc.nextInt();
        Q = sc.nextInt();

        sc.close();

        DFS1(0);

        System.out.println(ans);
    }
}

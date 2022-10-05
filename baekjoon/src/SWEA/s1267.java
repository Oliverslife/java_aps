package SWEA;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class s1267 {

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);

        int V, E, from, to, now;
        int[] in_degree;
        boolean[][] data;
        Queue<Integer> q;


        for(int tc=1; tc<=10; tc++) {

            sb.append("#" + tc + " ");
            V = sc.nextInt();
            E = sc.nextInt();
            in_degree = new int[V];
            data = new boolean[V][V];

            for(int i=0; i<E; i++) {
                from = sc.nextInt() - 1;
                to = sc.nextInt() - 1;
                data[from][to] = true;
                in_degree[to]++;
            }

            q = new ArrayDeque<>();
            for(int i=0; i<V; i++)
                if(in_degree[i] == 0)
                    q.offer(i);

            while(!q.isEmpty()) {
                now = q.poll();
                sb.append(now + 1 + " ");

                for(int i=0; i<V; i++)
                    if(data[now][i])		//현재 지점에서 i로 가는 간선이 존재한다면
                        if(--in_degree[i] == 0)
                            q.offer(i);
            }
            sb.append("\n");

        }
        sc.close();
        System.out.println(sb);


    }

}
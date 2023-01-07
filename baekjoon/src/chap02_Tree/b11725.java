package chap02_Tree;

import java.util.*;

public class b11725 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        List<TreeSet<Integer>> list = new ArrayList<>();

        int N = sc.nextInt();
        for(int i=0; i<N; i++)
            list.add(new TreeSet<>());

        int from, to;
        for(int i=1; i<N; i++) {
            from = sc.nextInt() - 1;
            to = sc.nextInt() - 1;
            list.get(from).add(to);
            list.get(to).add(from);
        }
        sc.close();

        boolean[] visited = new boolean[N];
        int[] ans = new int[N];

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(0);
        visited[0] = true;

        int cur;
        while(!q.isEmpty()) {
            cur = q.poll();
            for(int x : list.get(cur)) {
                if(!visited[x]) {
                    visited[x] = true;
                    q.offer(x);
                    ans[x] = cur + 1;   // x 노드는 cur을 부모 노드로 갖는다.
                }
            }
        }

        for(int i=1; i<N; i++)
            sb.append(ans[i]).append("\n");

        System.out.println(sb);

    }
}

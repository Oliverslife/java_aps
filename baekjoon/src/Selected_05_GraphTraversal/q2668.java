package Selected_05_GraphTraversal;

import java.util.*;

public class q2668 {

    static int n, i;
    static int[] graph;
    static boolean[] visited;
    static Set<Integer> ans = new TreeSet<>();

    static void dfs(int now) {
        if(now == i && visited[i]) {
            for (int i = 0; i < n; i++)
                if (visited[i])
                    ans.add(i + 1);
            return;
        }

        visited[now] = true;
        if(!visited[graph[now]] || graph[now] == i)
            dfs(graph[now]);
    }

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        //일단 그래프는 만들어 보자
        graph = new int[n];
        for(int i=0; i<n; i++)
            graph[i] = sc.nextInt() - 1;
        sc.close();

        //vertex당 연결할 수 있는 edge는 어차피 단 하나이므로 끝까지 dfs돌릴 때 i로 되돌아온다면 그 경로의 모든 숫자는 답이 될 수 있나? > 그러면 graph는 list배열이 필요가 없네?
        for(i=0; i<n; i++) {
            visited = new boolean[n];
            dfs(i);
        }

        sb.append(ans.size() + "\n");
        for(int x : ans)
            sb.append(x + "\n");
        System.out.print(sb.toString());

    }

}

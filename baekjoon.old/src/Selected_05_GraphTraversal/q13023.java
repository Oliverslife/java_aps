package Selected_05_GraphTraversal;

import java.io.*;
import java.util.*;

public class q13023 {

    static List<Integer>[] graph;
    static boolean[] visited;
    static int ans = -1;

    static void dfs(int now, int depth) {
        visited[now] = true;

        if(depth == 4) {
            ans = 1;
            return;
        }

        for(int x : graph[now])
            if(!visited[x]) {
                dfs(x, depth + 1);
                visited[x] = false;
            }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n];
        for(int i=0; i<n; i++)
            graph[i] = new ArrayList<>();

        int a, b;
        while(m-- > 0) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        for(int i=0; i<n; i++) {
            visited = new boolean[n];
            dfs(i, 0);
            if(ans == 1)
                break;
        }

        ans = ans == -1 ? 0 : 1;

        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();

    }
}

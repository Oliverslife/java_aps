package Selected_05_GraphTraversal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class q11725_bfs {
    static List<TreeMap<Integer, Integer>> list = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int vertex = Integer.parseInt(br.readLine());
        for(int i=0; i<vertex; i++)
            list.add(new TreeMap<>());

        int from, to;
        for(int i=0; i<vertex-1; i++) {
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken())-1;
            to = Integer.parseInt(st.nextToken())-1;
            list.get(from).put(to, from);
            list.get(to).put(from, to);
        }

        boolean[] visited = new boolean[vertex];
        int[] ans = new int[vertex];

        Queue<Integer> q = new ArrayDeque<>();
        q.add(0);
        visited[0] = true;

        while(!q.isEmpty()) {
            int tmp = q.poll();
            for(int x : list.get(tmp).keySet()) {
                if(!visited[x]) {
                    visited[x] = true;
                    q.add(x);
                    ans[x] = tmp + 1;
                }
            }
        }

        for(int i=1; i<vertex; i++)
            sb.append(ans[i]).append("\n");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}

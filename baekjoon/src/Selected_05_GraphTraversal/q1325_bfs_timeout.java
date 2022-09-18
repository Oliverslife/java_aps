package Selected_05_GraphTraversal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class q1325_bfs_timeout {
    static int vertex, edge, ans, max = 0;
    static List<TreeMap<Integer, Integer>> list = new ArrayList<>();
    static void bfs(int num) {
        boolean[] visited = new boolean[vertex];
        Queue<Integer> q = new ArrayDeque<>();
        q.add(num);
        ans++;
        visited[num] = true;

        while(!q.isEmpty()) {
            int tmp = q.poll();
            for(int x : list.get(tmp).keySet()) {
                if(!visited[x]) {
                    visited[x] = true;
                    q.add(x);
                    ans++;
                }
            }
        }

    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        vertex = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());

        for(int i=0; i<vertex; i++)
            list.add(new TreeMap<>());

        int from, to;
        for(int i=0; i<edge; i++) {
            st = new StringTokenizer(br.readLine());
            to = Integer.parseInt(st.nextToken())-1;
            from = Integer.parseInt(st.nextToken())-1;
            list.get(from).put(to, from);
        }

        for(int i=0; i<vertex; i++) {
            ans = 0;
            bfs(i);
            if(ans > max) {
                max = ans;
                sb.setLength(0);
                sb.append(i + 1).append(" ");
            }
            else if(ans == max) {
                sb.append(i + 1).append(" ");
            }
        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}

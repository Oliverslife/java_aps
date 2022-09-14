package Selected_05_GraphTraversal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class q2606_dfs {
    static int ans = 0;
    static Node[] graph;
    static boolean[] visited;
    static class Node {
        int to;
        Node next;
        public Node(int to, Node next) {
            this.to = to;
            this.next = next;
        }
    }

    static void dfs(int cur) {
        visited[cur] = true;
        ans++;
        for(Node tmp = graph[cur]; tmp != null; tmp = tmp.next)
            if(!visited[tmp.to])
                dfs(tmp.to);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int vertex = Integer.parseInt(br.readLine());
        graph = new Node[vertex];
        visited = new boolean[vertex];
        int edge = Integer.parseInt(br.readLine());

        for(int i=0; i<edge; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken())-1;
            int to = Integer.parseInt(st.nextToken())-1;
            graph[from] = new Node(to, graph[from]);

            //무향그래프이므로
            graph[to] = new Node(from, graph[to]);
        }

        dfs(0);
        ans--;      //1번 컴퓨터는 제외

        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }
}

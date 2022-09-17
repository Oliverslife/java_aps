package Selected_05_GraphTraversal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class q1260_solving {
    static int vertex, edge;
    static Node[] graph;
    static boolean[] dvisited;
    static boolean[] bvisited;
    static StringBuilder sb = new StringBuilder();
    static class Node {
        int to;
        Node next;
        public Node(int to, Node next) {
            this.to = to;
            this.next = next;
        }
    }
    static void dfs(int cur) {
        dvisited[cur] = true;
        sb.append(cur + " ");
        for(Node tmp = graph[cur]; tmp != null; tmp = tmp.next)
            if(!dvisited[tmp.to])
                dfs(tmp.to);
    }
    static void bfs() {

        Queue<Node> q = new ArrayDeque<>();
        boolean[] visited = new boolean[vertex];

        visited[1] = true;
        q.offer(graph[1]);      //인접리스트의 헤드가 들어감.

        while(!q.isEmpty()) {   //큐가 비어있지 않다면
            Node cur = q.poll();    //꺼낸 후(첫 번째의 경우는 graph[0])
            sb.append(cur.to + " ");

            for(Node tmp = cur; tmp != null; tmp = tmp.next)
                if(!visited[tmp.to]) {  //방문하지 않았다면
                    visited[tmp.to] = true;     //방문처리 후
                    q.offer(graph[tmp.to]);     //인접한 vertex를 큐에 넣기
                }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        vertex = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        graph = new Node[vertex+1];
        dvisited = new boolean[vertex+1];
        bvisited = new boolean[vertex+1];

        for(int i=0; i<edge; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from] = new Node(to, graph[from]);
            graph[to] = new Node(to, graph[to]);
        }

        dfs(start);
        sb.append("\n");
        bfs();

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}

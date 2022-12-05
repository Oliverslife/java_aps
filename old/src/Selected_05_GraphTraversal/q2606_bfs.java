package Selected_05_GraphTraversal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class q2606_bfs {
    static int vertex, edge, ans = 0;
    static Node[] graph;
    static class Node {
        int to;
        Node next;
        public Node(int to, Node next) {
            this.to = to;
            this.next = next;
        }
    }

    static void bfs() {

        Queue<Node> q = new ArrayDeque<>();
        boolean[] visited = new boolean[vertex];

        visited[0] = true;
        q.offer(graph[0]);      //인접리스트의 헤드가 들어감.

        while(!q.isEmpty()) {   //큐가 비어있지 않다면
            Node cur = q.poll();    //꺼낸 후(첫 번째의 경우는 graph[0])
            ans++;

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
        StringTokenizer st;

        vertex = Integer.parseInt(br.readLine());
        graph = new Node[vertex];
        edge = Integer.parseInt(br.readLine());

        for(int i=0; i<edge; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken())-1;
            int to = Integer.parseInt(st.nextToken())-1;
            graph[from] = new Node(to, graph[from]);

            //무향그래프이므로
            graph[to] = new Node(from, graph[to]);
        }

        bfs();
        ans--;      //1번 컴퓨터는 제외

        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }
}

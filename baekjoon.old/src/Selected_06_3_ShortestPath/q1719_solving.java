package Selected_06_3_ShortestPath;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class q1719_solving {

    static int V, E;
    static Node[] nodes;
    static int[][] ans;

    static class Node implements Comparable<Node> {
        int no, weight;
        Node next;
        public Node(int no, int weight) {
            this.no = no;
            this.weight = weight;
        }
        public Node(int no, int weight, Node next) {
            this.no = no;
            this.weight = weight;
            this.next = next;
        }
        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    static void makeMap(int start) {

        List<Integer> route = new ArrayList<>();

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        boolean[] visited = new boolean[V];
        Queue<Node> q = new PriorityQueue<>();
        q.offer(new Node(start, 0));

        int cnt = 0;

        while(!q.isEmpty()) {
            Node now = q.poll();
            if(visited[now.no]) continue;
            visited[now.no] = true;
            route.add(now.no);
            if(++cnt == V)  break;

            for(Node tmp = nodes[now.no]; tmp != null; tmp = tmp.next) {
                if(!visited[tmp.no] && dist[tmp.no] > dist[now.no] + tmp.weight) {
                    dist[tmp.no] = dist[now.no] + tmp.weight;
                    q.offer(new Node(tmp.no, dist[tmp.no]));
                }
            }
        }

        System.out.println(Arrays.toString(route.toArray()));
        for(int i=0; i<V; i++)
            ans[start][i] = dist[i];

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        nodes = new Node[V];
        ans = new int[V][V];

        int from, to, weight;
        for(int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken()) - 1;
            to = Integer.parseInt(st.nextToken()) - 1;
            weight = Integer.parseInt(st.nextToken());
            nodes[from] = new Node(to, weight, nodes[from]);
            nodes[to] = new Node(from, weight, nodes[to]);
        }

        for(int i=0; i<V; i++)
            makeMap(i);

        for(int i=0; i<V; i++) {
            for (int j = 0; j < V; j++) {
                if(i == j)
                    sb.append("- ");
                else
                    sb.append(ans[i][j] + " ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

}

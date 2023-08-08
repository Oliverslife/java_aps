package Selected_06_1_MST;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class q1922_Prim {

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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int from, to, weight, cnt = 0, ans = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        Node[] nodes = new Node[V];

        for(int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken()) - 1;
            to = Integer.parseInt(st.nextToken()) - 1;
            weight = Integer.parseInt(st.nextToken());
            nodes[from] = new Node(to, weight, nodes[from]);
            nodes[to] = new Node(from ,weight, nodes[to]);
        }

        boolean[] visited = new boolean[V];
        Queue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0, 0));

        int[] min = new int[V];     //최소 비용을 갱신할 배열
        min[0] = 0;                 //시작 정점
        Arrays.fill(min, Integer.MAX_VALUE);

        while(!pq.isEmpty()) {
            Node now = pq.poll();
            if(visited[now.no])
                continue;
            visited[now.no] = true;
            ans += now.weight;
            if(++cnt == V)
                break;
            for(Node tmp = nodes[now.no]; tmp != null; tmp = tmp.next) {
                if(!visited[tmp.no] && min[tmp.no] > tmp.weight) {
                    min[tmp.no] = tmp.weight;
                    pq.offer(new Node(tmp.no, tmp.weight));
                }
            }
        }
        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }
}

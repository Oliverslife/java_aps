package Selected_06_MST;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class q14621_Prim {

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
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        boolean[] univ = new boolean[V];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<V; i++)
            univ[i] = st.nextToken().equals("M") ? true : false;

        Node[] nodes = new Node[V];
        for(int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            int weight = Integer.parseInt(st.nextToken());
            if(univ[from] == univ[to])  continue;
            nodes[from] = new Node(to, weight, nodes[from]);
            nodes[to] = new Node(from, weight, nodes[to]);
        }

        boolean[] visited = new boolean[V];
        int[] min = new int[V];
        Arrays.fill(min, Integer.MAX_VALUE);
        min[0] = 0;
        Queue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0, 0));

        int ans = 0;
        int cnt = 0;

        while(!pq.isEmpty()) {
            Node n = pq.poll();
            if(visited[n.no])   continue;
            visited[n.no] = true;
            ans += n.weight;
            if(++cnt == V)  break;

            for(Node tmp = nodes[n.no]; tmp != null; tmp = tmp.next)
                if(!visited[tmp.no] && min[tmp.no] > tmp.weight) {
                    min[tmp.no] = tmp.weight;
                    pq.offer(new Node(tmp.no, tmp.weight));
                }
        }
        ans = cnt == V ? ans : -1;
        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();

    }
}

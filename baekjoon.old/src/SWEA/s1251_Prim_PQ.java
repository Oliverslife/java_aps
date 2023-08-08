package SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class s1251_Prim_PQ {
    static class Node implements Comparable<Node> {
        int no;
        long weight;
        public Node(int no, long weight) {
            this.no = no;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.weight, o.weight);
        }
    }

    static class Point {
        int r, c;
        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        ArrayList<Node>[] adjlist;
        Queue<Node> pq;
        boolean[] visited;
        List<Point> island;
        double rate;
        int V, cnt;
        long ans;

        int t = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=t; tc++) {

            V = Integer.parseInt(br.readLine());        //섬의 개수
            island = new ArrayList<>();

            st = new StringTokenizer(br.readLine());    //x좌표 받기
            for(int i=0; i<V; i++)
                island.add(new Point(Integer.parseInt(st.nextToken()), 0));

            st = new StringTokenizer(br.readLine());    //y좌표 받기
            for(int i=0; i<V; i++)
                island.set(i, new Point(island.get(i).r, Integer.parseInt(st.nextToken())));

            rate = Double.parseDouble(br.readLine());
            adjlist = new ArrayList[V];
            for(int i=0; i<V; i++) {
                adjlist[i] = new ArrayList<>();
                for(int j=0; j<V; j++) {
                    if(i == j)
                        continue;
                    long dx = Math.abs(island.get(i).r - island.get(j).r);
                    long dy = Math.abs(island.get(i).c - island.get(j).c);
                    adjlist[i].add(new Node(j, dx * dx + dy * dy));
                }
            }
            pq = new PriorityQueue<>();
            visited = new boolean[V];
            cnt = 0;
            ans = 0;
            pq.offer(new Node(0, 0));   //0번 노드부터?

            while(!pq.isEmpty()) {
                Node n = pq.poll();
                if(visited[n.no])
                    continue;
                ans += n.weight;
                visited[n.no] = true;
                if(++cnt == V)
                    break;

                for(int i=0; i<adjlist[n.no].size(); i++) {
                    Node next = adjlist[n.no].get(i);
                    if(!visited[next.no])
                        pq.offer(next);
                }
            }

            sb.append("#" + tc + " " + Math.round(ans * rate) + "\n");

        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }
}

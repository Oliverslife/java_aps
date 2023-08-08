package Selected_06_1_MST;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q1647_Kruskal {

    static int V, E;
    static int[] p;
    static Edge[] edgelist;

    static class Edge implements Comparable<Edge> {
        int from, to, weight;
        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    static void make() {
        p = new int[V];
        for(int i=0; i<V; i++)
            p[i] = i;
    }

    static int find(int a) {
        if(p[a] == a)
            return a;
        return p[a] = find(p[a]);
    }

    static boolean union(int a, int b) {
        int ar = find(a);
        int br = find(b);
        if(ar == br)
            return false;
        p[br] = ar;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        edgelist = new Edge[E];
        for(int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            edgelist[i] = new Edge(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(edgelist);
        make();

        int cnt = 0;
        long ans = 0;
        for(Edge e : edgelist) {
            if(union(e.from, e.to)) {
                ans += e.weight;
                if(++cnt == V-2)
                    break;
            }
        }
        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }
}

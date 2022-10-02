package Selected_06_1_MST;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class q1368_Kruskal_v2 {

    static int[] p;
    static int V;

    static void make() {
        p = new int[V+1];   //가상의 Vertex 추가
        for(int i=0; i<V+1; i++)
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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        V = Integer.parseInt(br.readLine());
        List<Edge> elist = new ArrayList<>();

        for(int i=0; i<V; i++)
            elist.add(new Edge(V, i, Integer.parseInt(br.readLine())));

        for(int i=0; i<V; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<V; j++)
                elist.add(new Edge(i, j, Integer.parseInt(st.nextToken())));
        }

        Collections.sort(elist);

        make();
        long ans = 0;
        int cnt = 0;
        for(Edge e : elist) {
            if(union(e.from, e.to)) {
                ans += e.weight;
                if(++cnt == V)    break;
            }
        }
        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();

    }
}

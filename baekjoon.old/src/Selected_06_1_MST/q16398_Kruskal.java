package Selected_06_1_MST;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class q16398_Kruskal {

    static int[] p;
    static int n;

    static void makeSet() {
        p = new int[n];
        for(int i=0; i<n; i++)
            p[i] = i;
    }

    static int findSet(int a) {
        if(p[a] == a)
            return a;
        return p[a] = findSet(p[a]);
    }

    static boolean union(int a, int b) {
        int ar = findSet(a);
        int br = findSet(b);
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

        n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        List<Edge> elist = new ArrayList<>();
        for(int i=0; i<n-1; i++)
            for(int j=i+1; j<n; j++)
                elist.add(new Edge(i, j, map[i][j]));	//간선 리스트이므로 무향 고려할 필요 없음~

        boolean[] visited = new boolean[n];
        int[] min = new int[n];

        int cnt = 0;
        long ans = 0;

        Collections.sort(elist);
        makeSet();

        for(Edge e : elist) {
            if(union(e.from, e.to)) {
                ans += e.weight;
                if(++cnt == n-1)
                    break;
            }
        }

        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();

    }
}
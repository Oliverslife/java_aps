package Selected_06_MST;

import java.io.*;
import java.util.*;

public class q1774_Kruskal {
    static int V;
    static int[] p;

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

    static class Edge implements Comparable<Edge> {
        int from, to;
        double weight;

        public Edge(int from, int to, double weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Double.compare(this.weight, o.weight);
        }
    }

    static class Point {
        int r, c;
        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static double dist(Point A, Point B) {
        return Math.sqrt(Math.pow(A.r - B.r, 2) + Math.pow(A.c - B.c, 2));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        int linked = Integer.parseInt(st.nextToken());
        make();

        List<Point> gods = new ArrayList<>();
        for(int i=0; i<V; i++) {
            st = new StringTokenizer(br.readLine());
            gods.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        for(int i=0; i<linked; i++) {
            st = new StringTokenizer(br.readLine());
            union(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);
        }

        List<Edge> elist = new ArrayList<>();
        for(int i=0; i<V-1; i++)
            for(int j=i+1; j<V; j++) {
                elist.add(new Edge(i, j, dist(gods.get(i), gods.get(j))));
            }

        Collections.sort(elist);


        Queue<Double> record = new PriorityQueue<>(Comparator.reverseOrder());

        double ans = 0;
        int cnt = 0;
        for(Edge e : elist) {
            if(union(e.from, e.to)) {
                ans += e.weight;
                record.offer(e.weight);
                if(++cnt == V-1-linked)
                    break;
            }
        }

        bw.write(String.format("%.2f", ans));
        bw.flush();
        bw.close();
        br.close();
    }

}

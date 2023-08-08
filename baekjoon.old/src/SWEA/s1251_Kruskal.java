package SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class s1251_Kruskal {
    static int[] parents;
    static int V, E;
    static List<Edge> edgelist;     //몇 개가 될지 모르니 List로 두자.
    static class Edge implements Comparable<Edge> {
        int from, to;
        long weight;
        public Edge(int from, int to, long weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            if(this.weight > o.weight)
                return 1;
            else if(this.weight < o.weight)
                return -1;
            else
                return 0;
        }
    }

    static class Point {
        int r, c;
        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static void make() {    //크기가 1인 서로 소 집합 생성
        parents = new int[V];
        for(int i=0; i<V; i++) {    //모든 노드가 자신을 부모로 하는(대표자) 집합으로 만든다.
            parents[i] = i;
        }
    }

    static int find(int a) {
        if(parents[a] == a)
            return a;
        return parents[a] = find(parents[a]);   //우리의 대표자를 나의 부모로 : path compression
    }

    static boolean union(int a, int b) {    //리턴값 : true => union 성공
        int aRoot = find(a);
        int bRoot = find(b);

        if(aRoot == bRoot)
            return false;
        parents[bRoot] = aRoot;
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        List<Point> island;
        double rate;
        int cnt;
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
            edgelist = new ArrayList<>();
            for(int i=0; i<V; i++)
                for(int j=i+1; j<V; j++) {
                    long dx = Math.abs(island.get(i).r - island.get(j).r);
                    long dy = Math.abs(island.get(i).c - island.get(j).c);
                    edgelist.add(new Edge(i, j, dx * dx + dy * dy));    //길이의 제곱 (나중에 세율 rate와 곱해줌)
                }

            Collections.sort(edgelist);
            make();
            cnt = 0;
            ans = 0;
            for(Edge e : edgelist) {
                if(union(e.from, e.to)) {
                    ans += e.weight;
                    if(++cnt == V - 1)
                        break;
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

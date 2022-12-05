package SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class s3124_Prim_timeout {

    static class Node {
        int vertex, weight;
        Node next;
        public Node(int vertex, int weight, Node next) {
            this.vertex = vertex;
            this.weight = weight;
            this.next = next;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        int V, E;
        long ans;
        for(int tc=1; tc<=t; tc++) {

            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            Node[] adjlist = new Node[V];

            for(int i=0; i<E; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken()) - 1;
                int to = Integer.parseInt(st.nextToken()) - 1;
                int weight = Integer.parseInt(st.nextToken());

                //무향 그래프 처리
                adjlist[from] = new Node(to, weight, adjlist[from]);
                adjlist[to] = new Node(from, weight, adjlist[to]);
            }

            // Prim 알고리즘에 필요한 자료구조
            int[] minEdge = new int[V];     //각 정점 입장에서 신장트리에 포함된 정점과의 간선 비용 중 최소비용
            boolean[] visited = new boolean[V];     //신장트리에 포함 여부

            Arrays.fill(minEdge, Integer.MAX_VALUE);//최소값 관리하기 위해 초기화

            // 1. 임의의 시작점 처리, 0번 정점을 신장트리 구성의 시작점으로 해보자
            minEdge[0] = 0;
            ans = 0;    //최소신장트리 비용 누적

            for(int i=0; i<V; i++) {        // V개의 정점 처리하면 끝내기

                // step.1 신장트리의 구성에 포함되지 않은 정점 중 최소비용 정점 선택
                int min = Integer.MAX_VALUE;
                int minVertex = -1;
                for(int j=0; j<V; j++) {
                    if(!visited[j] && min > minEdge[j]) {       //신장트리에 포함되지 않은 정점이면서 최소비용이 갱신되는 경우
                        min = minEdge[j];
                        minVertex = j;
                    }
                }

                // step.2 신장트리에 추가
                visited[minVertex] = true;
                ans += min;

                // step.2 신장트리에 새롭게 추가되는 정점과 신장트리에 포함되지 않은 정점들의 기존 최소비용과 비교하여 최소값을 갱신
                //          신장트리에 새롭게 추가되는 정점의 모든 인접정점 들여다보며 처리
                for(Node tmp = adjlist[minVertex]; tmp != null; tmp = tmp.next) {
                    if(!visited[tmp.vertex] && minEdge[tmp.vertex] > tmp.weight) {
                        minEdge[tmp.vertex] = tmp.weight;
                    }
                }
            }
            sb.append("#" + tc + " " + ans + "\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}

package Selected_05_GraphTraversal;

import java.io.*;
import java.util.*;

public class q17472 {
    // 막막하다...
    // 일단 섬의 수 확인 및 구분 >> 4개라고 나와있네 >> 4개가 아니네 예시에 한해서 4개일 뿐... 2시간 소모
    // 섬마다 바다쪽으로 쏘면서 다른 섬까지의 거리 확인
    // 프림?

    static int n, m, ans, island;
    static int[][] map;
    static int[][] drc = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
    static Node[] nodes;

    static boolean in(int r, int c) { return r >= 0 && r < n && c >= 0 && c < m; }

    static class Point {
        int r, c;
        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

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

    static void indexing() {

        boolean[][] visited = new boolean[n][m];
        Queue<Point> q = new ArrayDeque<>();
        int tr, tc, idx = 2;    // idx는 map에 0과 1로 마킹되어 있으므로 2부터 시작
        Point p;

        for(int i=0; i<n; i++)
            for(int j=0; j<m; j++) {
                if(map[i][j] == 1 && !visited[i][j]) {

                    q.offer(new Point(i, j));
                    visited[i][j] = true;
                    map[i][j] = idx;

                    while(!q.isEmpty()) {
                        p = q.poll();

                        for(int k=0; k<4; k++) {
                            tr = p.r + drc[k][0];
                            tc = p.c + drc[k][1];
                            if(in(tr, tc) && !visited[tr][tc] && map[tr][tc] == 1) {
                                visited[tr][tc] = true;
                                map[tr][tc] = idx;
                                q.offer(new Point(tr, tc));
                            }
                        }
                    }
                    idx++;

                }
            }
        island = idx - 2;
        nodes = new Node[island];
    }

    static void searchbridge() {

        int bridge, tmp;

        for(int i=0; i<n; i++)
            for(int j=0; j<m; j++)
                if(map[i][j] != 0) {//섬이라면

                    //북쪽 탐색
                    tmp = i;
                    bridge = 0;
                    while(in(--tmp, j) && map[tmp][j] == 0)
                        bridge++;
                    if(in(tmp, j) && bridge >= 2) {
                        nodes[map[i][j] - 2] = new Node(map[tmp][j] - 2, bridge, nodes[map[i][j] - 2]);
                        nodes[map[tmp][j] - 2] = new Node(map[i][j] - 2, bridge, nodes[map[tmp][j] - 2]);
                    }

                    //남쪽 탐색
                    tmp = i;
                    bridge = 0;
                    while(in(++tmp, j) && map[tmp][j] == 0)
                        bridge++;
                    if(in(tmp, j) && bridge >= 2) {
                        nodes[map[i][j] - 2] = new Node(map[tmp][j] - 2, bridge, nodes[map[i][j] - 2]);
                        nodes[map[tmp][j] - 2] = new Node(map[i][j] - 2, bridge, nodes[map[tmp][j] - 2]);
                    }

                    //서쪽 탐색
                    tmp = j;
                    bridge = 0;
                    while(in(i, --tmp) && map[i][tmp] == 0)
                        bridge++;
                    if(in(i, tmp) && bridge >= 2) {
                        nodes[map[i][j] - 2] = new Node(map[i][tmp] - 2, bridge, nodes[map[i][j] - 2]);
                        nodes[map[i][tmp] - 2] = new Node(map[i][j] - 2, bridge, nodes[map[i][tmp] - 2]);
                    }

                    //동쪽 탐색
                    tmp = j;
                    bridge = 0;
                    while(in(i, ++tmp) && map[i][tmp] == 0)
                        bridge++;
                    if(in(i, tmp) && bridge >= 2) {
                        nodes[map[i][j] - 2] = new Node(map[i][tmp] - 2, bridge, nodes[map[i][j] - 2]);
                        nodes[map[i][tmp] - 2] = new Node(map[i][j] - 2, bridge, nodes[map[i][tmp] - 2]);
                    }

                }
    }

    static void link() {

        boolean[] visited = new boolean[island];
        int[] dist = new int[island];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        Queue<Node> q = new PriorityQueue<>();
        q.offer(new Node(0, 0));

        ans = 0;
        int cnt = 0;
        while(!q.isEmpty()) {
            Node now = q.poll();
            if(visited[now.no]) continue;
            visited[now.no] = true;
            ans += now.weight;
            if(++cnt == island) break;

            for(Node tmp = nodes[now.no]; tmp != null; tmp = tmp.next) {
                if(!visited[tmp.no] && dist[tmp.no] > tmp.weight) {
                    dist[tmp.no] = tmp.weight;
                    q.offer(new Node(tmp.no, tmp.weight));
                }
            }
        }
        ans = cnt != island ? -1 : ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        indexing();
        searchbridge();
        link();

        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();


//        for(int i=0; i<n; i++) {
//            for (int j = 0; j < m; j++)
//                System.out.print(map[i][j] + " ");
//            System.out.println();
//        }

    }

}

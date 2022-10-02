package Selected_05_GraphTraversal;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class q17472_solving {
    // 막막하다...
    // 일단 섬의 수 확인 및 구분 >> 4개라고 나와있네
    // 섬마다 바다쪽으로 쏘면서 다른 섬까지의 거리 확인
    // 다익스트라?

    static int n, m;

    static int[][] map;
    static int[][] drc = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };

    static boolean in(int r, int c) { return r >= 0 && r < n && c >= 0 && c < m; }

    static class Point {
        int r, c;
        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static class Node {
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
    }

    static void indexing() {

        boolean[][] visited = new boolean[n][m];
        Queue<Point> q = new ArrayDeque<>();
        int tr, tc, idx = 2;    // idx는 map에 0과 1로 마킹되어 있으므루 2부터 시작
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
    }

    static void searchbridge() {

        Point p;

        for(int i=0; i<n; i++)
            for(int j=0; j<m; j++)
                if(map[i][j] != 0) {
                    p = new Point(i, j);
                }

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



//        for(int i=0; i<n; i++) {
//            for (int j = 0; j < m; j++)
//                System.out.print(map[i][j] + " ");
//            System.out.println();
//        }

    }

}

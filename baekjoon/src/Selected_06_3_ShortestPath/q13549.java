package Selected_06_3_ShortestPath;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class q13549 {

//  원래 이 문제는 단순한 BFS를 요구하는 문제가 아닙니다. 왜냐하면, BFS를 하기 위해서는 모든 간선의 가중치가 동일해야 한다는 전제 조건이 필요하기 때문입니다.
//  이 문제는 가중치가 0인 간선이 있기 때문에 일반적으로는 단순한 BFS를 쓸 수 없으나, 문제의 특성 때문에 방문 순서에 따라서 단순 BFS로도 우연히도 항상 정답을 찾을 수 있을 뿐입니다.
//  왜 하필 이 순서로 하면 항상 정답이 나오는가를 증명하는 건 매우 복잡한 일입니다.
//
//  이 문제를 보다 일반화된 경우 (가중치가 0인 간선이 있는 경우)에 대해 해결하려면, 즉, 이 문제의 의도대로 풀려면 다음과 같은 방법들을 사용할 수 있습니다.
//
//  다익스트라 알고리즘
//  0-1 BFS: 가중치가 0인 간선에 연결된 정점은 큐의 맨 뒤가 아닌 맨 앞에 넣는 방법
//  * 2를 별도의 간선으로 생각하지 않고, +1이나 -1에 의한 좌표를 큐에 넣을 때 그 좌표의 2의 거듭제곱 배인 좌표들을 전부 큐에 넣는 방법

    static class Point implements Comparable<Point> {
        int x, time;
        public Point(int x, int time) {
            this.x = x;
            this.time = time;
        }

        @Override
        public int compareTo(Point o) {
            return this.time - o.time;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] map = new int[100001];
        Arrays.fill(map, Integer.MAX_VALUE);
        map[n] = 0;

        Queue<Point> pq = new PriorityQueue<>();
        pq.offer(new Point(n, 0));


        int nx, nt;
        while(!pq.isEmpty()) {
            Point now = pq.poll();

            nx = now.x + 1;
            nt = now.time + 1;
            if(nx <= 100000 && nt < map[nx]) {
                map[nx] = nt;
                pq.offer(new Point(nx, nt));
            }

            nx = now.x - 1;
            nt = now.time + 1;
            if(nx >= 0 && nt < map[nx]) {
                map[nx] = nt;
                pq.offer(new Point(nx, nt));
            }

            nx = now.x * 2;
            nt = now.time;     //비용 없음
            if(nx <= 100000 && nt < map[nx]) {
                map[nx] = nt;
                pq.offer(new Point(nx, nt));
            }

        }

        bw.write(map[m] + "");
        bw.flush();
        bw.close();
        br.close();
    }
}

package Selected_02_DataStructure;

import java.io.*;
import java.util.*;

public class q16235 {

    // 자료구조. 시작이 늦더라도 배웠던 자료구조들을 생각하며 충분히 고민하고 설계해야 갈아엎는 경우를 막을 수 있음.
    // 자료구조, 소팅 종류별 로직 복습 필요.

    static int n;
    static int[][] map, add;
    static int[][] drc = { {-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1} };
    static Queue<Tree> trees = new PriorityQueue<>();
    static List<Tree> alive = new ArrayList<>();
    static List<Tree> dead = new ArrayList<>();

    static boolean in(int r, int c) { return r >= 0 && c >= 0 && r < n && c < n; }

    static class Tree implements Comparable<Tree> {
        int r, c, age;
        public Tree(int r, int c, int age) {
            this.r = r;
            this.c = c;
            this.age = age;
        }
        @Override
        public int compareTo(Tree o) {
            return this.age - o.age;        // o.age를 그냥 age로 작성해서 오류
        }
    }

    static void year() {

        //봄
        while(!trees.isEmpty()) {
            Tree tmp = trees.poll();
            if(tmp.age > map[tmp.r][tmp.c])
                dead.add(tmp);
            else {
                map[tmp.r][tmp.c] -= tmp.age;
                tmp.age += 1;
                alive.add(tmp);
            }
        }

        //여름
        for(Tree tmp : dead)
            map[tmp.r][tmp.c] += tmp.age / 2;
        dead.clear();

        //가을
        for(Tree tmp : alive)
            if(tmp.age % 5 == 0)
                for(int i=0; i<8; i++)
                    if(in(tmp.r + drc[i][0], tmp.c + drc[i][1]))
                        trees.offer(new Tree(tmp.r + drc[i][0], tmp.c + drc[i][1], 1));
        trees.addAll(alive);
        alive.clear();

        //겨울
        for(int i=0; i<n; i++)
            for(int j=0; j<n; j++)
                map[i][j] += add[i][j];

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        add = new int[n][n];

        for(int i=0; i<n; i++)
            Arrays.fill(map[i], 5);

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++)
                add[i][j] = Integer.parseInt(st.nextToken());
        }

        int r, c, age;
        while(m-- > 0) {
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken()) - 1;
            c = Integer.parseInt(st.nextToken()) - 1;
            age = Integer.parseInt(st.nextToken());
            trees.offer(new Tree(r, c, age));
        }

        while(k-- > 0)
            year();

        bw.write(trees.size() + "");
        bw.flush();
        bw.close();
        br.close();

    }
}

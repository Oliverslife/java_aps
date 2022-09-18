package Selected_05_GraphTraversal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class q1260 {
    static int vertex, edge;
    static ArrayList<TreeMap<Integer, Integer>> list = new ArrayList<>();
    static boolean[] dvisited;
    static boolean[] bvisited;
    static StringBuilder sb = new StringBuilder();
    static void dfs(int cur) {
        dvisited[cur] = true;
        sb.append((cur + 1) + " ");
        TreeMap<Integer, Integer> tmp = list.get(cur);
        for(int x : tmp.keySet())       //숫자 순서대로 순회하기 위해 Node클래스 대신 TreeMap을 사용.
            if(!dvisited[x])
                dfs(x);
    }
    static void bfs(int start) {

        Queue<TreeMap<Integer, Integer>> q = new ArrayDeque<>();

        bvisited[start] = true;
        if(list.get(start).size() == 0) {       //첫 번째 vertex의 edge가 없을 경우
            sb.append((start + 1) + " ");
            return;
        }
        q.offer(list.get(start));

        while(!q.isEmpty()) {
            TreeMap<Integer, Integer> tmp = q.poll();
            sb.append((tmp.get(tmp.firstKey())+1) + " ");

            for(int x : tmp.keySet())
                if(!bvisited[x]) {
                    bvisited[x] = true;
                    q.offer(list.get(x));
                }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        vertex = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken())-1;
        dvisited = new boolean[vertex];
        bvisited = new boolean[vertex];

        for(int i=0; i<vertex; i++)
            list.add(new TreeMap<>());

        for(int i=0; i<edge; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken())-1;
            int to = Integer.parseInt(st.nextToken())-1;
            list.get(from).put(to, from);
            list.get(to).put(from, to);
        }

        dfs(start);
        sb.append("\n");
        bfs(start);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}

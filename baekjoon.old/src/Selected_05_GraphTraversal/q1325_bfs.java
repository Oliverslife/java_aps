package Selected_05_GraphTraversal;

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q1325_bfs {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int vertex = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] arr = new ArrayList[vertex];
        for(int i=0; i<vertex; i++)
            arr[i] = new ArrayList<>();

        for(int i=0; i<edge; i++) {
            st = new StringTokenizer(br.readLine());
            int b = Integer.parseInt(st.nextToken())-1;
            int a = Integer.parseInt(st.nextToken())-1;     //a를 해킹하면 b도 해킹 가능
            arr[a].add(b);
        }

        int[] ans = new int[vertex];

        for(int i=0; i<vertex; i++) {
            boolean[] visited = new boolean[vertex];
            Queue<Integer> q = new ArrayDeque<>();
            visited[i] = true;
            q.offer(i);

            while(!q.isEmpty()) {
                int tmp = q.poll();
                ans[i]++;
                for(int x : arr[tmp]) {
                    if(!visited[x]) {
                        visited[x] = true;
                        q.offer(x);
                    }
                }
            }
        }

        int max = 0;
        for(int i=0; i<vertex; i++)
            max = Math.max(max, ans[i]);
        for(int i=0; i<vertex; i++)
            if(ans[i] == max)
                sb.append((i+1) + " ");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }
}

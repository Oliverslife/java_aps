package Chap15_백트래킹;

import java.io.*;
import java.util.StringTokenizer;

public class q15649 {

    static boolean[] visited;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    static void dfs(int n, int m, int depth) throws IOException {

        if(depth == m) {
            for (int x : arr) {
                sb.append(x + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                arr[depth] = i + 1;
                dfs(n, m, depth + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[m];
        visited = new boolean[n];
        dfs(n, m, 0);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}

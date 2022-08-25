package Chap15_백트래킹;

import java.io.*;
import java.util.StringTokenizer;

public class q15651 {

    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    static void dfs(int n, int m, int depth) {

        if(depth == m) {
            for (int x : arr) {
                sb.append(x + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0; i<n; i++) {
            arr[depth] = i + 1;
            dfs(n, m, depth + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[m];
        dfs(n, m, 0);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}

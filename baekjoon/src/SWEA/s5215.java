package SWEA;

import java.io.*;
import java.util.StringTokenizer;

public class s5215 {

    static int n, l, ans;
    static int[][] foods;
    static boolean[] visited;

    static void check(int depth) {

        if(depth == n) {
            int tmpscore = 0, tmpcal = 0;
            for(int i=0; i<n; i++) {
                tmpscore += visited[i] ? foods[i][0] : 0;
                tmpcal += visited[i] ? foods[i][1] : 0;
            }
            if(tmpcal <= l)
                ans = Math.max(ans, tmpscore);
            return;
        }

        visited[depth] = true;
        check(depth + 1);
        visited[depth] = false;
        check(depth + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=t; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            l = Integer.parseInt(st.nextToken());
            foods = new int[n][2];
            visited = new boolean[n];

            for(int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine());
                foods[i][0] = Integer.parseInt(st.nextToken());
                foods[i][1] = Integer.parseInt(st.nextToken());
            }

            ans = 0;
            check(0);
            bw.write(String.format("#%d %d\n", tc, ans));

        }
        bw.flush();
        bw.close();
        br.close();
    }
}

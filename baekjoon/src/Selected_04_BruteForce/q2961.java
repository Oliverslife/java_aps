package Selected_04_BruteForce;

import java.io.*;
import java.util.StringTokenizer;

public class q2961 {
    static int n, ans = Integer.MAX_VALUE;
    static int[][] data;
    static void dfs(int depth, int a, int b, int selected) {
        if(depth == n) {
            if(selected != 0)
                ans = Math.min(ans, Math.abs(a - b));
            return;
        }

        dfs(depth + 1, a * data[depth][0], b + data[depth][1], selected + 1);
        dfs(depth + 1, a, b, selected);

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        data = new int[n][2];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            data[i][0] = Integer.parseInt(st.nextToken());
            data[i][1] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 1, 0, 0);

        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }
}

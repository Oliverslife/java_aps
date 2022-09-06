package Selected_03_Backtracking;

import java.io.*;
import java.util.StringTokenizer;

public class q3980 {
    static int ans;
    static boolean[] visited;
    static int[][] stat;
    static void dfs(int depth, int sum) {
        if(depth == 11) {
            ans = Math.max(ans, sum);
            return;
        }

        for(int i=0; i<11; i++) {
            if(!visited[i] && stat[depth][i] != 0) {
                visited[i] = true;
                dfs(depth + 1, sum + stat[depth][i]);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        while(n-- > 0) {
            ans = 0;
            visited = new boolean[11];
            stat = new int[11][11];
            for(int i=0; i<11; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<11; j++)
                    stat[i][j] = Integer.parseInt(st.nextToken());
            }
            dfs(0, 0);
            bw.write(ans + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

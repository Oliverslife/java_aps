package Selected_04_BruteForce;

import java.io.*;
import java.util.StringTokenizer;

public class q9079 {
    static int ans;
    static boolean[][] map;
    static boolean sameCheck() {
        for(int i=0; i<3; i++)
            for(int j=0; j<3; j++)
                if(map[i][j] != map[0][0])
                    return false;
        return true;

    }
    static void dfs(int depth) {
        if(sameCheck()) {
            ans = Math.min(ans, depth);
            return;
        }
        if(depth == 8)
            return;

        for(int i=0; i<3; i++)
            map[0][i] = !map[0][i];
        dfs(depth + 1);
        for(int i=0; i<3; i++)
            map[0][i] = !map[0][i];

        for(int i=0; i<3; i++)
            map[1][i] = !map[1][i];
        dfs(depth + 1);
        for(int i=0; i<3; i++)
            map[1][i] = !map[1][i];

        for(int i=0; i<3; i++)
            map[2][i] = !map[2][i];
        dfs(depth + 1);
        for(int i=0; i<3; i++)
            map[2][i] = !map[2][i];

        for(int i=0; i<3; i++)
            map[i][0] = !map[i][0];
        dfs(depth + 1);
        for(int i=0; i<3; i++)
            map[i][0] = !map[i][0];

        for(int i=0; i<3; i++)
            map[i][1] = !map[i][1];
        dfs(depth + 1);
        for(int i=0; i<3; i++)
            map[i][1] = !map[i][1];

        for(int i=0; i<3; i++)
            map[i][2] = !map[i][2];
        dfs(depth + 1);
        for(int i=0; i<3; i++)
            map[i][2] = !map[i][2];

        map[0][0] = !map[0][0];
        map[1][1] = !map[1][1];
        map[2][2] = !map[2][2];
        dfs(depth + 1);
        map[0][0] = !map[0][0];
        map[1][1] = !map[1][1];
        map[2][2] = !map[2][2];

        map[0][2] = !map[0][2];
        map[1][1] = !map[1][1];
        map[2][0] = !map[2][0];
        dfs(depth + 1);
        map[0][2] = !map[0][2];
        map[1][1] = !map[1][1];
        map[2][0] = !map[2][0];

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            ans = Integer.MAX_VALUE;
            map = new boolean[3][3];
            for(int i=0; i<3; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<3; j++)
                    map[i][j] = st.nextToken().equals("H") ? true : false;
            }

            dfs(0);

            ans = ans == Integer.MAX_VALUE ? -1 : ans;
            bw.write(ans + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

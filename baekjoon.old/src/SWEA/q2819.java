package SWEA;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class q2819 {
    static int[][] map = new int[4][4];
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static Set<String> filter = new HashSet<>();
    static void check(int r, int c, int depth, String str) {
        if(depth == 7) {
            filter.add(str);
            return;
        }

        for(int i=0; i<4; i++) {
            int tr = r + dr[i];
            int tc = c + dc[i];
            if(tr >= 0 && tr < 4 && tc >= 0 && tc < 4) {
                String tmp = str + map[r][c];
                check(tr, tc, depth + 1, tmp);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++) {

            filter.clear();
            for(int i=0; i<4; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<4; j++)
                    map[i][j] = Integer.parseInt(st.nextToken());
            }

            for(int i=0; i<4; i++)
                for(int j=0; j<4; j++)
                    check(i, j, 0, "");

            bw.write(String.format("#%d %d\n", tc, filter.size()));
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

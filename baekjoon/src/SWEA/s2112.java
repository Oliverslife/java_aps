package SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class s2112 {

    static int d, w, k, ans;
    static boolean[][] map;

    static boolean pass() {

        int cnt;
        boolean before;

        for(int i=0; i<w; i++) {

            before = map[0][i];
            cnt = 1;

            for(int j=1; j<d; j++) {
                cnt = before == map[j][i] ? cnt + 1 : 1;
                before = map[j][i];
                if(cnt == k)
                    break;
            }

            if(cnt < k)
                return false;
        }
        return true;
    }

    static void dfs(int depth, int cnt) {

        if(cnt >= ans)
            return;

        if(depth == d) {
            if(pass())
                ans = Math.min(ans, cnt);
            return;
        }
        boolean[] tmp = new boolean[w];
        for(int i=0; i<w; i++)
            tmp[i] = map[depth][i];

        //그대로 가는 경우
        dfs(depth + 1, cnt);

        //1로 바꾼 경우
        Arrays.fill(map[depth], true);
        dfs(depth + 1, cnt + 1);
        for(int i=0; i<w; i++)
            map[depth][i] = tmp[i];

        //0으로 바꾼 경우
        Arrays.fill(map[depth], false);
        dfs(depth + 1, cnt + 1);
        for(int i=0; i<w; i++)
            map[depth][i] = tmp[i];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=t; tc++) {
            st = new StringTokenizer(br.readLine());

            d = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            map = new boolean[d][w];
            ans = Integer.MAX_VALUE;

            for(int i=0; i<d; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<w; j++)
                    map[i][j] = st.nextToken().equals("1") ? true : false;
            }

            dfs(0, 0);

            sb.append("#" + tc + " " + ans + "\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

}

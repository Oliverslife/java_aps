package SSAFY_IM준비;

import java.io.*;
import java.util.StringTokenizer;

public class q10163 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int[][] map = new int[1001][1001];
        int n = Integer.parseInt(br.readLine()), x1, y1, x2, y2;
        int[] ans = new int[n+1];

        for(int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            for(int j=y1; j<y1+y2; j++)
                for(int k=x1; k<x1+x2; k++)
                    map[j][k] = i;
        }
        for(int i=0; i<1001; i++)
            for(int j=0; j<1001; j++)
                ans[map[i][j]]++;

        for(int i=1; i<=n; i++)
            sb.append(ans[i] + "\n");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}

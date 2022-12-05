package ETC;

import java.io.*;
import java.util.StringTokenizer;

public class q16395 {
    static int[][] p = new int[31][31];

    static int dp(int n, int k) {

        if(p[n][k] > 0)
            return p[n][k];
        if(k == 0 || n == k)
            return p[n][k] = 1;
        return p[n][k] = (dp(n-1, k-1) + dp(n-1, k));

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        bw.write(dp(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1) + "");
        bw.flush();
        bw.close();
        br.close();
    }
}

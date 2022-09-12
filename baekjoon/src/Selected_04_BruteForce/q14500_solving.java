package Selected_04_BruteForce;

import java.io.*;
import java.util.StringTokenizer;

public class q14500_solving {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] data = new int[n][m];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++)
                data[i][j] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;
        int tmp;
        for(int i=0; i<n-1; i++) {
            for(int j=0; j<m-1; j++) {
                tmp = 0;
                tmp += data[i][j] + data[i+1][j] + data[i][j+1] + data[i+1][j+1];
                ans = Math.max(ans, tmp);
            }
        }
        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }
}

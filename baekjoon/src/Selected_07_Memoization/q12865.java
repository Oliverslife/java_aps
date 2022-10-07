package Selected_07_Memoization;

import java.io.*;
import java.util.StringTokenizer;

public class q12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] data = new int[n+1][2];
        int[][] bag = new int[n+1][k+1];

        for(int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            data[i][0] = Integer.parseInt(st.nextToken());  //무게
            data[i][1] = Integer.parseInt(st.nextToken());  //가치
        }

        for(int i=1; i<=n; i++)
            for(int j=0; j<=k; j++)
                bag[i][j] = data[i][0] <= j ? Math.max(bag[i-1][j], bag[i-1][j - data[i][0]] + data[i][1]) : bag[i-1][j];

        bw.write(bag[n][k] + "");
        bw.flush();
        bw.close();
        br.close();
    }
}

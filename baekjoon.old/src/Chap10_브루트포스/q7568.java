package Chap10_브루트포스;

import java.io.*;
import java.util.StringTokenizer;

public class q7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int rank;

        int n = Integer.parseInt(br.readLine());
        int[][] data = new int[n][2];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            data[i][0] = Integer.parseInt(st.nextToken());
            data[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<n; i++) {
            rank = 1;
            for(int j=0; j<n; j++) {
                if(i == j)
                    continue;
                else if(data[i][0] < data[j][0] && data[i][1] < data[j][1])
                    rank++;
            }
            bw.write(String.valueOf(rank) + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

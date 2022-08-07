package Chap07_기본수학1;

import java.io.*;
import java.util.Arrays;

public class q2775 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[][] map = new int[16][14];
        for(int i=0; i<16; i++) {
            Arrays.fill(map[i], 1);
        }
        int t = Integer.parseInt(br.readLine());
        for(int whatthehellisthis = 0; whatthehellisthis<t; whatthehellisthis++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            for(int i=14; i>=0; i--) {
                for(int j=1; j<14; j++) {
                    map[i][j] = map[i][j-1] + map[i+1][j];
                }
            }
            bw.write(String.valueOf(map[14-k][n-1]));
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

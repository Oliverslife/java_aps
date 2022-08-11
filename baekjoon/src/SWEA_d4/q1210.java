package SWEA_d4;

import java.io.*;
import java.util.StringTokenizer;

public class q1210 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int[][] lad;
        int x = 0;
        int y = 0;

        for(int i=1; i<=10; i++) {
            int n = Integer.parseInt(br.readLine());
            lad = new int[100][102];
            for(int j=0; j<100; j++) {
                st = new StringTokenizer(br.readLine());
                for(int k=1; k<101; k++) {
                    lad[j][k] = Integer.parseInt(st.nextToken());
                    if(lad[j][k] == 2) {
                        x = j;
                        y = k;
                    }
                }
            }

            while(x != 0) {
                if(lad[x][y-1] == 0 && lad[x][y+1] == 0) {
                    x--;
                }
                else if(lad[x][y-1] == 1) {
                    while(lad[x][y-1] == 1) {
                        y--;
                    }
                    x--;
                }
                else if(lad[x][y+1] == 1) {
                    while(lad[x][y+1] == 1) {
                        y++;
                    }
                    x--;
                }
            }

            bw.write(String.format("#%d %d", n, y-1));
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

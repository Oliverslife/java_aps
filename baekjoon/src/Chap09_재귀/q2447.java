package Chap09_재귀;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class q2447 {

    static boolean[][] star(int n) {
        boolean[][] result;
        boolean[][] unit;
        boolean[][] blank;
        int cnt = 0;

        if(n == 3) {							//base unit
            result = new boolean[n][n];
            for(int i=0; i<3; i++) {
                Arrays.fill(result[i], true);
            }
            result[1][1] = false;
            return result;
        }

        else {
            result = new boolean[n][n];			//answer
            unit = star(n/3);					//sub unit
            blank = new boolean[unit.length][unit.length];

            for(int i=0; i<n; i+=unit.length) {
                for(int j=0; j<n; j+=unit.length) {
                    cnt++;
                    for(int k=0; k<unit.length; k++) {
                        if(cnt == 5) {
                            System.arraycopy(blank[k], 0, result[i+k], j, unit.length);
                            continue;
                        }
                        System.arraycopy(unit[k], 0, result[i+k], j, unit.length);
                    }
                }
            }

        }
        return result;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        boolean[][] ans = star(n);
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(ans[i][j])
                    bw.write("*");
                else
                    bw.write(" ");
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();

    }
}
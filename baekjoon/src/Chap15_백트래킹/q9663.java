package Chap15_백트래킹;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class q9663 {
    static int n, ans = 0;
    static boolean[] sero, d1, d2;

    static void chess(int depth) {
        if(depth == n) {
            ans++;
            return;
        }

        for(int i=0; i<n; i++) {
            if(!sero[i] && !d1[depth + i] && !d2[depth - i + n - 1]) {
                sero[i] = true;
                d1[depth+i] = true;
                d2[depth-i+n-1] = true;
                chess(depth + 1);
                sero[i] = false;
                d1[depth+i] = false;
                d2[depth-i+n-1] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        sero = new boolean[n];
        d1 = new boolean[2*n - 1];	//x+y 확인
        d2 = new boolean[2*n - 1];	//x-y 확인
        chess(0);
        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }
}

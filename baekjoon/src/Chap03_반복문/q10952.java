package Chap03_반복문;

import java.io.*;
import java.util.StringTokenizer;

public class q10952 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        boolean is_on = true;
        int a, b;

        while (is_on) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            if (a == 0 && b == 0) {
                is_on = false;
                break;
            }
            bw.write(String.valueOf(a + b));
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

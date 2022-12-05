package Chap03_반복문;

import java.io.*;
import java.util.StringTokenizer;

public class q11022 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int a, b;

        int n = Integer.parseInt(br.readLine());
        for (int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            bw.write(String.format("Case #%d: %d + %d = %d", i, a, b, a + b));
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}